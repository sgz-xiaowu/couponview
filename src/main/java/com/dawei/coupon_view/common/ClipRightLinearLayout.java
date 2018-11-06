package com.dawei.coupon_view.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

import com.dawei.coupon_view.R;
import com.dawei.coupon_view.util.ScreenUtils;

/**
 * 优惠券剪切线性布局，漏出右边的凹槽
 * @author seagull
 */
public class ClipRightLinearLayout extends LinearLayoutCompat {


    private int mTopCircleColor;
    private int mBottomCircleColor;
    private float mCircleRadius;
    private Paint mPaint;

    public ClipRightLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public ClipRightLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.coupon_clipLinearlayout);
        mTopCircleColor = typedArray.getColor(R.styleable.coupon_clipLinearlayout_topCircleColor,
                ContextCompat.getColor(context, android.R.color.white));
        mBottomCircleColor = typedArray.getColor(R.styleable.coupon_clipLinearlayout_bottomCircleColor,
                ContextCompat.getColor(context, android.R.color.white));
        mCircleRadius = typedArray.getDimension(R.styleable.coupon_clipLinearlayout_circleRadius,
                ScreenUtils.dip2px(context, 13));
        init(context);

    }

    public ClipRightLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawCircle(canvas);
    }

    private void drawCircle(Canvas canvas){
        //需要关闭硬件加速（没有关闭则没效果）
//        setLayerType(LAYER_TYPE_SOFTWARE, null); 渐变背景的view，可以不关闭硬件加速，但其父容器必须关闭硬件加速
        //设置离屏绘制
//        int layerID = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        //画左上角的圆
//        mPaint.setColor(mTopCircleColor);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(getWidth(),0 , mCircleRadius, mPaint);
//        mPaint.setXfermode(null);

        //画左下角的圆
//        mPaint.reset();
//        mPaint.setColor(mBottomCircleColor);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(getWidth(),getHeight() , mCircleRadius, mPaint);
        mPaint.setXfermode(null);

//        canvas.restoreToCount(layerID);
    }


}
