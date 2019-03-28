package com.nchung.netodo.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nchung.netodo.di.ViewModelFactory
import com.nchung.netodo.di.ViewModelKey
import com.nchung.netodo.ui.drawer_menu.DrawerMenuViewModel
import com.nchung.netodo.ui.home.HomeViewModel
import com.nchung.netodo.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DrawerMenuViewModel::class)
    abstract fun bindDrawerMenuViewModel(drawerMenuViewModel: DrawerMenuViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}