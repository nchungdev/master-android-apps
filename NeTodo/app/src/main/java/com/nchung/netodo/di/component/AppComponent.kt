package com.nchung.netodo.di.component

import android.app.Application
import com.nchung.netodo.NeToDoApp
import com.nchung.netodo.di.builder.ActivityBuilder
import com.nchung.netodo.di.module.AppModule
import com.nchung.netodo.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    ViewModelModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: NeToDoApp)
}
