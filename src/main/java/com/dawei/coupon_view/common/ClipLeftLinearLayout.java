package com.dawei.coupon_view.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

import com.dawei.coupon_view.R;
import com.dawei.coupon_view.util.ScreenUtils;

/**
 * 优惠券剪切线性布局，漏出左边的凹槽
 * @author seagull
 */
public class ClipLeftLinearLayout extends LinearLayoutCompat {

    private int mTopCircleColor;
    private int mBottomCircleColor;
    private float mCircleRadius;
    private Paint mPaint;

    public ClipLeftLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public ClipLeftLinearLayout(Context context, AttributeSet attrs) {
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

    public ClipLeftLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        mPaint = new Paint();
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawCircle(canvas);
    }

    private void drawCircle(Canvas canvas){


        //画左上角的圆
        mPaint.setColor(mTopCircleColor);
        canvas.drawCircle(0,0 , mCircleRadius, mPaint);

        //画左下角的圆
        mPaint.reset();
        mPaint.setColor(mBottomCircleColor);
        canvas.drawCircle(0,getHeight() , mCircleRadius, mPaint);
    }



}
