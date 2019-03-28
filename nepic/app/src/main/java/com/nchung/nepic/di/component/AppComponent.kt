package com.nchung.nepic.di.component

import android.app.Application
import com.nchung.nepic.NePicApp
import com.nchung.nepic.di.builder.ActivityBuilder
import com.nchung.nepic.di.module.AppModule
import com.nchung.nepic.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(instance: NePicApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
