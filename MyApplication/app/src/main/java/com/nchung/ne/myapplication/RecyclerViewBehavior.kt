package com.nchung.ne.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout

class RecyclerViewBehavior @JvmOverloads constructor(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<FrameLayout>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: FrameLayout, dependency: View): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: FrameLayout, dependency: View): Boolean {
        return super.onDependentViewChanged(parent, child, dependency)
    }
}