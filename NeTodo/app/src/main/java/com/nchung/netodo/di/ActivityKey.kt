package com.nchung.netodo.di

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityKey(val value: KClass<out Activity>)
