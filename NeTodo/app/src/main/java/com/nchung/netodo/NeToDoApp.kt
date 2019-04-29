package com.nchung.netodo

import com.nchung.netodo.di.component.AppComponent
import com.nchung.netodo.di.module.AppModule
import dagger.android.DaggerApplication

class NeToDoApp : DaggerApplication() {
    val appComponent: AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

    override fun applicationInjector(): AppComponent = appComponent
}
