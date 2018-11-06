package com.dawei.coupon_view.util;

import android.content.Context;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/30 14:34
 */

public class ScreenUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
