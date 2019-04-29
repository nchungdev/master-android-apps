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
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        Completable.timer(TIME_SPLASH, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.postValue(false) }
                .doOnComplete { isLoading.postValue(true) }
                .subscribe()
                .addTo(compositeDisposable)
    }

    companion object {
        private const val TIME_SPLASH = 2500L
    }
}
