package com.dawei.coupon_view

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewOutlineProvider
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_coupon.*

class CouponActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coupon)

        var contentView = CouponContainer(this)
//        setContentView(contentView)


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CouponAdapter()
        recycler.addItemDecoration(SpacesItemDecoration(30))
//        initView(contentView)
//        initAlpha()
        initAutoText()
    }

    private fun initAutoText() {
        text_shadow.outlineProvider = ViewOutlineProvider.BACKGROUND
        btn_expand.setOnClickListener {
            if (getString(R.string.btn_expand) == btn_expand.text) {
                text_more_less.maxLines = 5
                btn_expand.text = getString(R.string.btn_shrink)
            } else {
                text_more_less.maxLines = 3
                btn_expand.text = getString(R.string.btn_expand)
            }
        }
    }

    private fun initAlpha() {
        btn_change.setOnClickListener {
            var alpha = edit_alpha.text?.toString()?.toFloat()
            image.alpha = alpha!!
            image.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN)
            ll_image.alpha = alpha
            btn_change.alpha = alpha
        }
    }

    private fun initView(contentView: CouponContainer) {
        var tv1 = TextView(this).apply { text = "左侧第一行view" }
        contentView.addLeftContent(tv1)
        var tv2 = TextView(this).apply { text = "左侧第二行view" }
        contentView.addLeftContent(tv2)

        var tv3 = TextView(this).apply { text = "右侧第一行view" }
        contentView.addRightContent(tv3)
        var tv4 = TextView(this).apply { text = "右侧第二行view" }
        contentView.addRightContent(tv4)
    }

}


