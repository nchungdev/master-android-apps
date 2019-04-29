package com.nchung.netodo.di.module

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun providesContext(): Context {
        return application.applicationContext
    }

    @Provides
    fun providesLayoutInflater(): LayoutInflater = LayoutInflater.from(providesContext())
}
