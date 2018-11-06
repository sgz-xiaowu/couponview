package com.dawei.coupon_view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.item_coupon.view.*
import kotlinx.android.synthetic.main.widget_coupon_container.view.*

/**
 * @author shendawei
 * @func
 * @email shendawei0727@163.com
 * @time 2018/10/22 18:08
 */
class CouponAdapter : RecyclerView.Adapter<CouponAdapter.CouponHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CouponHolder {
//        return CouponHolder(CouponContainer(parent?.context))
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_coupon, parent, false)
        return CouponHolder(view)
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: CouponHolder?, position: Int) {
        holder?.bindData()
    }

    class CouponHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData() {
            /*(itemView as CouponContainer)?.apply {
                var tv1 = TextView(itemView.context).apply { text = "左侧第一行view，左侧第一行文本" }
                addLeftContent(tv1)
                var tv2 = TextView(itemView.context).apply { text = "左侧第二行view，左侧第二行文本" }
                addLeftContent(tv2)

                var tv3 = TextView(itemView.context).apply { text = "右侧第一行view，右侧第一行文本" }
                addRightContent(tv3)
                var tv4 = TextView(itemView.context).apply { text = "右侧第二行view，右侧第二行文本" }
                addRightContent(tv4)
            }*/
/*            with(itemView) {
                container?.apply {
                    var tv1 = TextView(itemView.context).apply { text = "左侧第一行view，左侧第一行文本" }
                    addLeftContent(tv1)
                    var tv2 = TextView(itemView.context).apply { text = "左侧第二行view，左侧第二行文本" }
                    addLeftContent(tv2)

                    var tv3 = TextView(itemView.context).apply { text = "右侧第一行view，右侧第一行文本" }
                    addRightContent(tv3)
                    var tv4 = TextView(itemView.context).apply { text = "右侧第二行view，右侧第二行文本" }
                    addRightContent(tv4)
                }
            }*/
            ((itemView as LinearLayout).getChildAt(0) as? CouponContainer) ?.apply {
                initLeftPart()
                initRightPart()
                var tv1 = TextView(context).apply { text = "左侧第一行view，左侧第一行文本，左侧第一行结尾" }
                addLeftContent(tv1)
                var tv2 = TextView(context).apply { text = "左侧第二行view，左侧第二行文本，左侧第一行结尾" }
                addLeftContent(tv2)

                var tv3 = TextView(context).apply { text = "右侧第一行view，右侧第一行文本，右侧第一行结尾" }
                addRightContent(tv3)
                var tv4 = TextView(context).apply { text = "右侧第二行view，右侧第二行文本，右侧第一行结尾" }
                addRightContent(tv4)
            }


        }
    }
}
