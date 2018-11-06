package com.dawei.coupon_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/29 17:46
 */

public class MyImageJava extends android.support.v7.widget.AppCompatImageView {
    public MyImageJava(Context context) {
        super(context);
    }

    public MyImageJava(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageJava(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setColor(Color.RED);
        //使用离屏绘制，新建图层
//        int layerID = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);
        //绘制核心代码
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cc);
        canvas.drawBitmap(bitmap, 0, 0, paint);
//        paint.setColor(Color.BLACK);
//        canvas.drawCircle(getWidth()*0.52f, getHeight()*0.3f, 30f, paint);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(getWidth()*0.8f, getHeight()*0.3f, 30f, paint);
        paint.setColorFilter(null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawCircle(getWidth()*0.52f, getHeight()*0.3f, 30f, paint);
        //还原图层
//        canvas.restoreToCount(layerID);
    }
}
