package com.nchung.ne.myapplication

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val itemAdapter = ItemAdapter(this)
        itemAdapter.items.addAll(
                listOf(Item(), Item(), Item(), Item(), Item(), Item(), Item(), Item())
        )
        recyclerView.adapter = itemAdapter
        val min = resources.getDimensionPixelSize(R.dimen.height_item_min)
        val max = resources.getDimensionPixelSize(R.dimen.height_item_max)
        val layoutParams = recyclerView.layoutParams as LinearLayout.LayoutParams
        val valueAnimator = ValueAnimator.ofInt(max, min)
        val valueAnimatorReverse = ValueAnimator.ofInt(min, max)
        var flag = true
        valueAnimator.addUpdateListener {
            layoutParams.height = it.animatedValue as Int
            recyclerView.layoutParams = layoutParams
            (recyclerView.adapter as ItemAdapter).notifyDataSetChanged()
            flag = false
        }
        valueAnimatorReverse.addUpdateListener {
            layoutParams.height = it.animatedValue as Int
            recyclerView.layoutParams = layoutParams
            (recyclerView.adapter as ItemAdapter).notifyDataSetChanged()
            flag = true
        }
        valueAnimator.duration = 300L
        valueAnimatorReverse.duration = 300L
        button.setOnClickListener {
            if (flag) {
                valueAnimator.start()
            } else {
                valueAnimatorReverse.start()
            }
        }
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                (layoutManager.findFirstVisibleItemPosition() until layoutManager.findLastVisibleItemPosition()).forEach {
//                    val holder = recyclerView.findViewHolderForAdapterPosition(it) as ItemAdapter.ViewHolder
//                    holder.animation()
//                }
//            }
//        })
    }
}
