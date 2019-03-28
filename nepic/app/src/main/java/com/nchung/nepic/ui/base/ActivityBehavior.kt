package com.nchung.nepic.ui.base

import android.support.annotation.LayoutRes

interface ActivityBehavior<VM : BaseViewModel<*>> {
    @LayoutRes
    fun getLayoutId(): Int

    fun bindViews()

    fun getViewModel(): VM

    fun setupNavigator()
}
