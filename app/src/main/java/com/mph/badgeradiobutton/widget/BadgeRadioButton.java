package com.mph.badgeradiobutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.mph.badgeradiobutton.R;

/**
 * Created by：hcs on 2016/10/13 15:09
 * e_mail：aaron1539@163.com
 */
public class BadgeRadioButton extends RadioButton {

    private Paint mBgPaint;
    private Paint mTextPaint;
    private int mNum;

    /**
     * 需要绘制的数字大小
     * 默认大小为8sp
     */
    private float mTextSize = sp2px(8);

    /**
     * 默认背景颜色
     */
    private int mBgColor = 0xffff0000;

    /**
     * 默认字体颜色
     */
    private int mTextColor = 0xffffffff;

    //圆心坐标
    private int mX = 0;
    private int mY = 0;

    public BadgeRadioButton(Context context) {
        super(context,null);
    }

    public BadgeRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public BadgeRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs){

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BadgeRadioButton);

        mTextColor = a.getColor(R.styleable.BadgeRadioButton_badge_txt_color,0xffffffff);
        mBgColor = a.getColor(R.styleable.BadgeRadioButton_badge_bg_color,0xffff0000);
        mTextSize = a.getDimensionPixelSize(R.styleable.BadgeRadioButton_badge_txt_size,(int)sp2px(8));
        mNum = a.getInteger(R.styleable.BadgeRadioButton_badge_txt_num,-1);

        //画背景圆形
        mBgPaint=new Paint();
        mBgPaint.setAntiAlias(true);

        //绘制数字
        mTextPaint=new Paint();
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextPaint.setAntiAlias(true);

        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mX = getWidth()*2/3;
        mY = getHeight()/4;
        mTextPaint.setTextSize(mTextSize);

        if(mNum>0){

            mBgPaint.setColor(mBgColor);
            canvas.drawCircle(mX, mY, dp2px(10), mBgPaint);

            String str = null;
            if(mNum>99){
                str = "99+";
            }else{
                str=new String(mNum+"");
            }
            //绘制的文本
            mTextPaint.setColor(mTextColor);
            canvas.drawText(str,mX- mTextPaint.measureText(str) / 2,mY+mTextPaint.getFontMetrics().bottom*1.2f,mTextPaint);
        }else{
            mBgPaint.setColor(0x00000000);
            canvas.drawCircle(mX, mY, dp2px(10), mBgPaint);
            String str = "";
            //颜色
            mTextPaint.setColor(0x00ffffff);
            canvas.drawText(str,mX- mTextPaint.measureText(str) / 2,mY+mTextPaint.getFontMetrics().bottom*1.2f,mTextPaint);
        }
    }

    /**
     * 设置提醒数字
     * @param mNum
     */
    public void setmNum(int mNum) {
        this.mNum = mNum;
        invalidate();
    }

    /**
     * 清除提醒数字
     */
    public void clearNum(){
        this.mNum = -1;
        invalidate();
    }

    /**
     * 设置数字颜色
     * @param textColor
     */
    public void setTextColor(int textColor) {
        this.mTextColor = textColor;
    }

    /**
     * 设置数字背景
     * @param bgColor
     */
    public void setBgColor(int bgColor) {
        this.mBgColor = bgColor;
    }

    /**
     * 设置提示数字大小，单位sp
     * @param textSize
     */
    public void setTextSize(int textSize) {
        this.mTextSize = textSize;
    }

    /**
     * 将dp转为px
     * @param dp
     * @return
     */
    private int dp2px(int dp){
        int ret = 0;
        ret = (int) (dp * getContext().getResources().getDisplayMetrics().density);
        return ret;
    }

    /**
     * 将sp值转换为px值
     * @param sp
     * @return
     */
    private float sp2px(int sp) {
        float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }
}
