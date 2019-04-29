package com.nchung.netodo.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
