#自定义View
##步骤：
### 1 获取自定义属性值
####其中属性的类型一般分为以下几种：
+ reference：某一资源ID。
+ color：颜色值。
+ boolean：布尔值。
+ dimension：尺寸值。注意,这里如果是dp那就会做像素转换。
+ float：浮点值。
+ integer：整型值。
+ string：字符串
+ fraction：百分数。
+ enum：枚举值。
+ flag：自定义,里面对应了自定义的属性值。
+ reference|color：颜色的资源文件。
+ reference|boolean：布尔值的资源文件
```java
<declare-styleable name="CustomSwitchView">
     <attr name="switch_background" format="reference" />
     <attr name="switch_foreground" format="reference" />
     <attr name="switch_state" format="boolean" />
</declare-styleable>
xmlns:customswitch="http://schemas.android.com/apk/res-auto"
customswitch:switch_background="@drawable/switch_background"
customswitch:switch_foreground="@drawable/switch_foreground"
customswitch:switch_state="true"
```
JAVA:
```java
// 设置命名空间
String namespace = "http://schemas.android.com/apk/res-auto";
int switchBackgroundResource =
               attrs.getAttributeResourceValue(namespace, "switch_background", -1);
 ```
###2 初始化一些初始值
###3 在onMeasure测量View的大小，亦可设置view的大小
```java
//动态设置View宽高，覆盖布局文件里面的设置大小
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {          
setMeasuredDimension(switchBackgroupBitmap.getWidth(), switchBackgroupBitmap.getHeight());
        }
```
###4 在onLayout里面获取子view的大小
###5 onDraw 绘制具体的View，动画效果可以通过刷新实现
      draw->刷新->draw->刷新......
###6 onTouch 获取，滑动距离（x,y），invalidate()刷新UI
###7 自定义回调接口，在onTouch中实现