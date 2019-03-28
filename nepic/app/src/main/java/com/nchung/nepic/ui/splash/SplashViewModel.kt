package com.nchung.nepic.ui.splash

import com.n8plus.blog.ui.splash.SplashNavigator
import com.nchung.nepic.ui.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel<SplashNavigator>( ) {

    fun setTimeout(timeout: Long) {
        Completable.timer(timeout, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    getNavigator().openMainActivity()
                }
                .addTo(compositeDisposable)
    }
}

