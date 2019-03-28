package com.nchung.nepic.ui.base

import android.support.annotation.LayoutRes
import android.view.View

interface FragmentBehavior<VM : BaseViewModel<*>> {
    @LayoutRes
    fun getLayoutId(): Int

    fun bindViews(view: View? = null)

    fun getViewModel(): VM

    fun setupNavigator()
}
