package com.nchung.netodo.customview

import androidx.annotation.IntDef
import com.google.android.material.appbar.AppBarLayout

abstract class AppBarStateChangeListener : AppBarLayout.OnOffsetChangedListener {

    private var currentState = State.IDLE

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        when {
            verticalOffset == 0 -> {
                if (currentState != State.EXPANDED) {
                    onStateChanged(appBarLayout, State.EXPANDED)
                }
                currentState = State.EXPANDED
            }
            Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0 -> {
                if (currentState != State.COLLAPSED) {
                    onStateChanged(appBarLayout, State.COLLAPSED)
                }
                currentState = State.COLLAPSED
            }
            else -> {
                if (currentState != State.IDLE) {
                    onStateChanged(appBarLayout, State.IDLE)
                }
                currentState = State.IDLE
            }
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout, @State state: Int)

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(value = [State.EXPANDED, State.COLLAPSED, State.IDLE])
    annotation class State {
        companion object {
            const val EXPANDED = 1
            const val COLLAPSED = 0
            const val IDLE = -1
        }
    }
}
