package com.nchung.netodo.di.module

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideLayoutInflater(context: Context): LayoutInflater = LayoutInflater.from(context)
}
