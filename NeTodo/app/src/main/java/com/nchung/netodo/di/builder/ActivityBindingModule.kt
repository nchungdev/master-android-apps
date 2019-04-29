package com.nchung.netodo.di.builder

import com.nchung.netodo.ui.home.HomeActivity
import com.nchung.netodo.ui.home.HomeActivitySubcomponent
import com.nchung.netodo.ui.splash.SplashActivity
import com.nchung.netodo.ui.splash.SplashActivitySubcomponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [
    SplashActivitySubcomponent::class,
    HomeActivitySubcomponent::class
])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(SplashActivity::class)
    abstract fun splashActivityInjectorFactory(impl: SplashActivitySubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(HomeActivity::class)
    abstract fun homeActivityInjectorFactory(impl: HomeActivitySubcomponent.Factory): AndroidInjector.Factory<*>
}
