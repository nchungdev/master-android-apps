package com.nchung.netodo.ui.splash

import androidx.lifecycle.MutableLiveData
import com.nchung.netodo.ui.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        setTimeout(500L)
    }

    private fun setTimeout(timeout: Long) {
        Completable.timer(timeout, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loading.value = true }
            .doOnComplete { loading.value = false }
            .subscribe()
            .addTo(compositeDisposable)
    }
}
