package com.nchung.netodo.di

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityKey(val value: KClass<out Activity>)
