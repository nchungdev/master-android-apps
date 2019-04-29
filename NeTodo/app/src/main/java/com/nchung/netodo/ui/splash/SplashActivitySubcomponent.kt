package com.nchung.netodo.ui.splash

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SplashModule::class])
interface SplashActivitySubcomponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SplashActivity>
}
