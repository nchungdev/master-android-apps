package com.nchung.nepic.ui.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N : Navigator> : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    private var navigator: WeakReference<N>? = null

    fun getNavigator(): N {
        val weakReference = navigator ?: throw NullPointerException("Navigator is null")
        return weakReference.get() ?: throw NullPointerException("Navigator is null")
    }

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
