package com.dawei.coupon_view.common;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/23 16:36
 */

public class LeftPartDrawable extends GradientDrawable {

    public LeftPartDrawable() {
        this(new int[]{0, 0}, 0f);
    }

    public LeftPartDrawable(int[] colors, float radius) {
        super(Orientation.BL_TR, colors);
        setCornerRadii(new float[]{radius, radius, 0f, 0f, 0f, 0f, radius, radius});
//        setStroke(6, Color.MAGENTA, 20, 10);
        setStroke(3, Color.LTGRAY);
    }
}
