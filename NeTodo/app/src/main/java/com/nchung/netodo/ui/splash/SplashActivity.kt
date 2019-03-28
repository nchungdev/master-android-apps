package com.nchung.netodo.ui.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseActivity
import com.nchung.netodo.ui.home.HomeActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun bindViews() {

    }

    override fun getLayoutId() = R.layout.activity_splash

    override fun getViewModel(): SplashViewModel = splashViewModel

    private val splashViewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        getViewModel(this, SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().loading.observe(this, Observer {
            if (it) {
                openMainActivity()
            }
        })
    }

    private fun openMainActivity() {
        val intent = HomeActivity.makeIntent(this)
        startActivity(intent)
        finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }
}
