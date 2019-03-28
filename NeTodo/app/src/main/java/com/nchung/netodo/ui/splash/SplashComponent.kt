package com.nchung.netodo.ui.splash

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent : AndroidInjector<SplashActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SplashActivity>()
}