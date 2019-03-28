package com.nchung.nepic.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nchung.nepic.R
import com.nchung.nepic.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>(), HomeNavigator {
    override fun setupNavigator() = getViewModel().setNavigator(this)

    private val homeViewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewModel(this, HomeViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun bindViews() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun makeIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
