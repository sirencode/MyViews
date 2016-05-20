package syh.demo.myviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Diablo on 16/5/19.
 * 自定义Switch控件
 */
public class CustomSwitchView extends View{

    //定义背景图
    private Bitmap switchBackgroupBitmap;

    //定义前景图
    private Bitmap switchForegroupBitmap;

    private boolean isSwitchState = true; //开关状态

    private boolean isTouchState = false; //触摸状态

    private float currentPosition; // 当前开关位置

    private int maxPosition; // 开关滑动最大位置

    private OnSwitchStateUpdateListener onSwitchStateUpdateListener;

    /**
     * @Description:用于代码创建控件
     */
    public CustomSwitchView(Context context) {
        super(context);
    }

    /**
     * @Description:用于在XML中使用，可以指定自定义属性
     */
    public CustomSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    /**
     * @Description:用于在XML中使用，可以指定自定义属性，并指定样式
     */
    public CustomSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    /**
     * 获取自定义属性
     * @param attrs
     */
    private void initAttrs(AttributeSet attrs){
        // 设置命名空间
        String namespace = "http://schemas.android.com/apk/res-auto";
        int switchBackgroundResource =
                attrs.getAttributeResourceValue(namespace, "switch_background", -1);
        int switchForegroundResource =
                attrs.getAttributeResourceValue(namespace, "switch_foreground", -1);
        isSwitchState = attrs.getAttributeBooleanValue(namespace, "switch_state", false);
        // 将资源对象设置到对应位置
        setBackgroundPic(switchBackgroundResource);
        setForegroundPic(switchForegroundResource);
    }
    /**
     * @Description:设置背景图
     */
    public void setBackgroundPic(int switchBackground) {
        switchBackgroupBitmap = BitmapFactory.decodeResource(getResources(), switchBackground);
    }

    /**
     * @Description:设置前景图
     */
    public void setForegroundPic(int switchForeground) {
        switchForegroupBitmap = BitmapFactory.decodeResource(getResources(), switchForeground);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(switchBackgroupBitmap.getWidth(), switchBackgroupBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        // 先绘制背景
        canvas.drawBitmap(switchBackgroupBitmap, 0, 0, paint);

        // 如果处于触摸状态
        if (isTouchState) {
            // 触摸位置在开关的中间位置
            float movePosition = currentPosition - switchForegroupBitmap.getWidth() / 2.0f;
            maxPosition = switchBackgroupBitmap.getWidth() - switchForegroupBitmap.getWidth();
            // 限定开关滑动范围 只能在 0 - maxPosition范围内
            if (movePosition < 0) {
                movePosition = 0;
            } else if (movePosition > maxPosition) {
                movePosition = maxPosition;
            }
            // 绘制开关
            canvas.drawBitmap(switchForegroupBitmap, movePosition, 0, paint);
        }
        // 直接绘制开关
        else {
            // 如果是真，直接将开关滑块置为开启状态
            if (isSwitchState) {
                maxPosition = switchBackgroupBitmap.getWidth() - switchForegroupBitmap.getWidth();
                canvas.drawBitmap(switchForegroupBitmap, maxPosition, 0, paint);
            } else {
                // 否则将开关置为关闭状态
                canvas.drawBitmap(switchForegroupBitmap, 0, 0, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 处于触摸状态
                isTouchState = true;
                // 得到位置坐标
                currentPosition = event.getX();
                break;

            case MotionEvent.ACTION_MOVE:
                currentPosition = event.getX();
                break;

            case MotionEvent.ACTION_UP:
                // 触摸状态结束
                isTouchState = false;
                currentPosition = event.getX();
                // 中间标志位置
                float centerPosition = switchBackgroupBitmap.getWidth() / 2.0f;

                // 如果开关当前位置大于背景位置的一半 显示关 否则显示开
                boolean currentState = currentPosition > centerPosition;

                // 如果当然状态不相同且绑定了监听对象 则执行监听方法
                if (currentState != isSwitchState && onSwitchStateUpdateListener != null) {
                    onSwitchStateUpdateListener.onStateUpdate(currentState);
                }

                // 当前状态置为开关状态
                isSwitchState = currentState;
                break;
        }
        // 重新调用onDraw方法，不断重绘界面
        invalidate();
        return true;
    }

    public void setOnSwitchStateUpdateListener(OnSwitchStateUpdateListener
                                                       onSwitchStateUpdateListener) {
        this.onSwitchStateUpdateListener = onSwitchStateUpdateListener;
    }

    public interface OnSwitchStateUpdateListener {
        // 状态回调, 把当前状态传出去
        void onStateUpdate(boolean state);
    }
}
