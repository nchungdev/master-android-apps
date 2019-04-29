package com.nchung.netodo.di.component

import com.nchung.netodo.NeToDoApp
import com.nchung.netodo.di.builder.ActivityBindingModule
import com.nchung.netodo.di.builder.FragmentBindingModule
import com.nchung.netodo.di.module.AppModule
import com.nchung.netodo.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<NeToDoApp>
