package com.dawei.coupon_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/29 17:29
 */
class MyImage(context: Context?) : ImageView(context) {

    constructor(context: Context?, attrs: AttributeSet): this(context)

    constructor(context: Context?, attrs: AttributeSet, style: Int) : this(context, attrs)

    /*override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        var paint = Paint().apply {
            isAntiAlias = true
//            colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_OUT)
            color = Color.RED
        }
//        canvas?.drawCircle((width*0.8).toFloat(), (height*0.3).toFloat(), 30f, paint)
    }*/
}