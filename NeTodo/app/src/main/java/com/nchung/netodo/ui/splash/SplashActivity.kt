package com.nchung.netodo.ui.splash

import androidx.lifecycle.Observer
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseActivity
import com.nchung.netodo.ui.home.HomeActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun getLayoutId() = R.layout.activity_splash

    private val viewModel by lazy {
        getViewModel(this, SplashViewModel::class.java)
    }

    private fun openMainActivity() {
        val intent = HomeActivity.makeIntent(this)
        startActivity(intent)
        finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }

    override fun bindViews() {
        viewModel.isLoading.observe(this, Observer {
            if (it) {
                openMainActivity()
            }
        })
    }
}
