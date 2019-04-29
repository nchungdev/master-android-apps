package com.nchung.netodo.ui.home

import android.content.Context
import android.content.Intent
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {
    private val viewModel by lazy {
        getViewModel(this, HomeViewModel::class.java)
    }

    override fun getLayoutId() = R.layout.activity_home

    override fun bindViews() {

    }

    companion object {

        fun makeIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}
