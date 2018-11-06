package com.dawei.coupon_view.common;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/23 16:36
 */

public class RightPartDrawable extends GradientDrawable {

    public RightPartDrawable() {
        this(0f);
    }

    public RightPartDrawable(float radius) {
        super();
        setColor(Color.WHITE);
        setCornerRadii(new float[]{0f, 0f, radius, radius, radius, radius, 0f, 0f});
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
//        int layerId = canvas.saveLayer(new RectF(getBounds()), paint, Canvas.ALL_SAVE_FLAG);
        paint.setShadowLayer(4, 6, 6, Color.GRAY);
        canvas.drawRoundRect(0, 0, 300, 300, 16, 16, paint);
//        canvas.drawRect(getBounds(), paint);
//        canvas.restoreToCount(layerId);
    }
}
