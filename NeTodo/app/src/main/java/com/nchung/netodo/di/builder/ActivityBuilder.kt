package com.nchung.netodo.di.builder

import android.app.Activity
import com.nchung.netodo.di.ActivityKey
import com.nchung.netodo.ui.home.HomeActivity

import com.nchung.netodo.ui.home.HomeComponent
import com.nchung.netodo.ui.splash.SplashActivity
import com.nchung.netodo.ui.splash.SplashComponent

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(SplashActivity::class)
    abstract fun bindSplashActivity(builder: SplashComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivity(builder: HomeComponent.Builder): AndroidInjector.Factory<out Activity>

}
