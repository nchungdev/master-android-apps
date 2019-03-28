package com.nchung.netodo.ui.drawer_menu

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DrawerMenuFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideDrawerMenuFragmentFactory(): DrawerMenuFragment
}