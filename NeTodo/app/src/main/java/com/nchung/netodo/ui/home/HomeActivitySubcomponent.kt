package com.nchung.netodo.ui.home

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeModule::class])
interface HomeActivitySubcomponent : AndroidInjector<HomeActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<HomeActivity>
}