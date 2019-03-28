package com.nchung.nepic.ui.splash

import android.os.Bundle
import com.n8plus.blog.ui.splash.SplashNavigator
import com.nchung.nepic.R
import com.nchung.nepic.ui.base.BaseActivity
import com.nchung.nepic.ui.home.HomeActivity

class SplashActivity: BaseActivity<SplashViewModel>(), SplashNavigator {

    override fun setupNavigator() = getViewModel().setNavigator(this)

    override fun bindViews() {

    }

    override fun getLayoutId() = R.layout.activity_splash

    override fun getViewModel(): SplashViewModel = splashViewModel

    private val splashViewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewModel(this, SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.setTimeout(5000L)
    }

    override fun openLoginActivity() {

    }

    override fun openMainActivity() {
        val intent = HomeActivity.makeIntent(this)
        startActivity(intent)
        finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }
}
