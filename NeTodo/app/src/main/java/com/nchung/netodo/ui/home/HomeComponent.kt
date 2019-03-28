package com.nchung.netodo.ui.home

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeModule::class])
interface HomeComponent : AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}