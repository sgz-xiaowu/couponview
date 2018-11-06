package com.dawei.coupon_view.constant;

import com.dawei.coupon_view.R;

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/19 17:28
 */

public enum RectColor {
    /*红券*/
    RED(R.color.coupon_1_start_color, R.color.coupon_1_end_color),
    /*蓝券*/
    BLUE(R.color.coupon_2_start_color, R.color.coupon_2_end_color),
    /*店铺券*/
    SHOP(R.color.coupon_3_start_color, R.color.coupon_3_end_color),
    /*购物券*/
    SHOPPING(R.color.coupon_4_start_color, R.color.coupon_4_end_color),
    /*理财券*/
    FINANCIAL(R.color.coupon_5_start_color, R.color.coupon_5_end_color),
    /*虚拟券*/
    VIRTUAL(R.color.coupon_6_start_color, R.color.coupon_6_end_color),
    /*美券*/
    BEAUTY(R.color.coupon_7_start_color, R.color.coupon_7_end_color),
    /*运费券*/
    FREIGHT(R.color.coupon_8_start_color, R.color.coupon_8_end_color);

    private int start = 0;
    private int end = 0;

    private RectColor(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStartColorRes() {
        return this.start;
    }

    public int getEndColorRes() {
        return this.end;
    }
}
