package com.nchung.nepic.di.builder

import com.nchung.nepic.ui.home.HomeActivity
import com.nchung.nepic.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}