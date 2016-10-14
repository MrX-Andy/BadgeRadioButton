# BadgeRadioButton
仿QQ底部Tab切换带数字提示的RadioButton，支持自定义提示数字背景颜色、字体大小、字体颜色。后续将持续更新......
#Preview
![image](https://github.com/hcs-xph/BadgeRadioButton/blob/master/screen/badge.gif)
#Usage xml
```java
<com.mph.badgeradiobutton.widget.BadgeRadioButton
            android:id="@+id/rb_home_tab_msg"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:checked="true"
            android:gravity="center"
            android:button="@null"
            android:paddingLeft="0dp"
            //设置背景颜色
            app:badge_bg_color="#ff0000"
            //设置提示消息数
            app:badge_txt_num="120"
            android:drawableTop="@drawable/rb_home_msg_selecter"
            />
```
直接使用，可以在xml中配置提示数字背景颜色、字体大小、字体颜色。
#attrs
```java
        <!-- 提示数字背景颜色 -->
        <attr name="badge_bg_color" format="color"/>
        <!-- 提示数字颜色 -->
        <attr name="badge_txt_color" format="color"/>
        <!-- 提示数字大小 -->
        <attr name="badge_txt_size" format="dimension|reference"/>
        <!-- 提示数字 -->
        <attr name="badge_txt_num" format="integer"/>
```
#Java
```java
//设置数字
mMsgRb.setmNum(60);
//清除提示数字
mMsgRb.clearNum();
```
同时提供了相应方法设置提示数字背景颜色、字体大小、字体颜色。
详细使用见源码！如果不符合需求也可根据需求自行修改......
