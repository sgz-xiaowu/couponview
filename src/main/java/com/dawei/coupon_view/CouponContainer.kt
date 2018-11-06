package com.dawei.coupon_view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.dawei.coupon_view.common.LeftPartDrawable
import com.dawei.coupon_view.common.RightPartDrawable
import com.dawei.coupon_view.constant.RectColor
import com.dawei.coupon_view.util.CouponResUtil
import com.dawei.coupon_view.util.ScreenUtils
import kotlinx.android.synthetic.main.widget_coupon_container.view.*

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/22 16:10
 */
class CouponContainer(context: Context?) : LinearLayout(context) {


    private var rate: Float = 0.0f
    private var radius: Float = 0f;
    fun setRadius(r: Float) {
        radius = r
    }

    constructor (context: Context, attrs: AttributeSet) : this(context)

    constructor(context: Context, attrs: AttributeSet, style: Int) : this(context, attrs)

    init {
        View.inflate(context, R.layout.widget_coupon_container, this)
//        LayoutInflater.from(context).inflate(R.layout.widget_coupon_container, this, true)
//        initLeftPart(left_group)
//        initRightPart(right_group)
        setRadius(16f)
        rate = (28.5 / 94.7).toFloat()
    }

    fun initLeftPart() {
//        var colors: IntArray = intArrayOf(CouponResUtil.getGradientStart(context, "3"), CouponResUtil.getGradientEnd(context, "3"))
//        var gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors).apply {
//            cornerRadii = floatArrayOf(16f, 16f, 0f, 0f, 0f, 0f, 16f, 16f)
//        }
//        gd.cornerRadius = 16.0f * resources.displayMetrics.density
        var gd = LeftPartDrawable(
                intArrayOf(CouponResUtil.getGradientStart(context, "1"), CouponResUtil.getGradientEnd(context, "1")),
                ScreenUtils.dip2px(context, 6f).toFloat()
        )
        left_group?.background = gd
    }

    fun initRightPart() {
//        var gd = GradientDrawable().apply {
//            setColor(CouponResUtil.getGradientStart(context, "2"))
//            cornerRadii = floatArrayOf(0f, 0f, 16f, 16f, 16f, 16f, 0f, 0f)
////            cornerRadius = 16.0f * resources.displayMetrics.density
//        }
        var gd = RightPartDrawable(ScreenUtils.dip2px(context, 6f).toFloat())
        right_group?.background = gd
    }

    fun addLeftContent(view: View) {
        left_group.addView(view)
    }

    fun addRightContent(view: View) {
        right_group.addView(view)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) //父容器要禁止硬件加速，才能保证不显示黑像素
        var pos = calculateCirclePosition()
        var paint = Paint()
//        paint.color = Color.RED
        paint.isAntiAlias = true
//        paint.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OUT)
//        canvas?.drawCircle(pos[0], pos[1], radius, paint)
//        paint.colorFilter = null
        //设置离屏绘制
//      两层view都要绘制混合模式时，采取“离屏绘制”，不会达到预期，父子混合都呈现之效果。
//        此处不需要创建新图层，进行“离屏绘制”
//        var layerID: Int = canvas?.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), paint, Canvas.ALL_SAVE_FLAG)!!
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas?.drawCircle(pos[0]/2, pos[1], radius, paint)
        paint.xfermode = null
//        canvas.restoreToCount(layerID)
    }

    /*onDraw viewgroup不调用*/
    /*override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var pos = calculateCirclePosition()
        var paint = Paint()
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        canvas?.drawCircle(pos[0], pos[1], radius, paint)
    }*/

    private fun calculateCirclePosition(): FloatArray {
        var x = width * rate
        var y = 0f
        return floatArrayOf(x, y)
    }
}