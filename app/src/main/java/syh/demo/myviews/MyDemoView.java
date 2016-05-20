package syh.demo.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Diablo on 16/5/20.
 */
public class MyDemoView extends View{

    private Paint mPaint;

    public MyDemoView(Context context) {
        super(context);
        init();
    }

    public MyDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDemoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿功能
        mPaint.setColor(Color.RED);  //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        mPaint.setStrokeWidth(10);//设置画笔宽度
    }
    //当View中所有的子控件均被映射成xml后触发
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    //确定所有子元素的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //当View分配所有的子元素的大小和位置时触发
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //当view的大小发生变化时触发
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    //view渲染内容的细节
    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawPoint(100, 10, mPaint);//画点
//        canvas.drawLine(30, 30, 300, 30, mPaint);//画线
//        canvas.drawRect(30, 50, 200, 200, mPaint);//画矩形
//
//        //rect:要画的矩形,rx:生成圆角的椭圆的X轴半径,ry:生成圆角的椭圆的Y轴半径
//        RectF rect = new RectF(30, 210, 300, 300);
//        canvas.drawRoundRect(rect, 20, 10, mPaint);
//
//        //cx：圆心点X轴坐标,cy：圆心点Y轴坐标,radius：圆的半径
//        canvas.drawCircle(400, 400, 80, mPaint);
//
//        RectF rect1 = new RectF(100, 550, 400, 660);
//        canvas.drawOval(rect1, mPaint);//同一个矩形画椭圆

//        //画弧度
//        RectF rect2 = new RectF(100, 700, 400, 800);
//        RectF rect3 = new RectF(500, 700, 800, 800);
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(rect2, 0, 90, true, mPaint);
//        canvas.drawArc(rect3, 0, 90, false, mPaint);
//
          //路径线段
//        Path path = new Path();
//        path.moveTo(30, 830); //设定起始点
//        //直线的结束点，又是下一次绘制直线路径的开始点
//        path.lineTo(30, 930);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(200, 930);//画第二条直线
//        path.lineTo(400, 930);//第三条直线
//        path.close();//如果连续画了几条直线，但没有形成闭环，调用Close()会将路径首尾点连接起来，形成闭环
//        canvas.drawPath(path, mPaint);

        //先创建两个大小一样的路径
        //第一个逆向生成
//        Path CCWRectpath = new Path();
//        RectF rect4 =  new RectF(50, 50, 240, 200);
//        CCWRectpath.addRect(rect4, Path.Direction.CCW);
//        //第二个顺向生成
//        Path CWRectpath = new Path();
//        RectF rect5 =  new RectF(290, 50, 480, 200);
//        CWRectpath.addRect(rect5, Path.Direction.CW);
//        //先画出这两个路径
//        canvas.drawPath(CCWRectpath, mPaint);
//        canvas.drawPath(CWRectpath, mPaint);


        //画字
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setTextSize(80);//设置文字大小
//        canvas.drawText("Hello View", 10,100, mPaint);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //当View获取或失去焦点时触发
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    //当窗口包含的view获取或失去焦点时触发
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    //当view被附着到一个窗口时触发
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    //当view离开附着的窗口时触发，Android123提示该方法和 onAttachedToWindow() 是相反的
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    //当窗口中包含的可见的view发生变化时触发
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }
}
