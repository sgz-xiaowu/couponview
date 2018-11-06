package com.dawei.coupon_view.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

import com.dawei.coupon_view.constant.CouponConstant;
import com.dawei.coupon_view.constant.RectColor;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/19 17:55
 */

public class CouponResUtil {

    public static int getGradientStart(Context context, String type) {
        RectColor rectColor = getRectColor(type);
        if (null != rectColor) {
            return ContextCompat.getColor(context, getRectColor(type).getStartColorRes());
        }

        return 0;
    }

    public static int getGradientEnd(Context context, String type) {
        RectColor rectColor = getRectColor(type);
        if (null != rectColor) {
            return ContextCompat.getColor(context, getRectColor(type).getEndColorRes());
        }

        return 0;
    }

    private static RectColor getRectColor(String type) {
        if (CouponConstant.TYPE_COUPON_RED.equals(type)) {
            return RectColor.RED;
        } else if (CouponConstant.TYPE_COUPON_BLUE.equals(type)) {
            return RectColor.BLUE;
        } else if (CouponConstant.TYPE_COUPON_SHOP.equals(type)) {
            return RectColor.SHOP;
        } else if (CouponConstant.TYPE_COUPON_SHOPPING.equals(type)) {
            return RectColor.SHOPPING;
        } else if (CouponConstant.TYPE_COUPON_FINANCIAL.equals(type)) {
            return RectColor.FINANCIAL;
        } else if (CouponConstant.TYPE_COUPON_VIRTUAL.equals(type)) {
            return RectColor.VIRTUAL;
        } else if (CouponConstant.TYPE_COUPON_BEAUTY.equals(type)) {
            return RectColor.BEAUTY;
        } else if (CouponConstant.TYPE_COUPON_FREIGHT.equals(type)) {
            return RectColor.FREIGHT;
        }

        return null;
    }

    private void changeColor(int color) {
        GradientDrawable drawable = null;
        drawable.setColors(new int[]{getGradientStart(null, null), getGradientEnd(null, null)});
    }
}
