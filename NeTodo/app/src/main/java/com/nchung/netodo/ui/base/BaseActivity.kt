package com.nchung.netodo.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.nchung.netodo.NeToDoApp
import com.nchung.netodo.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<VM : BaseViewModel> : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun bindViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        bindViews()
    }

    fun getViewModel(fragmentActivity: FragmentActivity, clazz: Class<VM>) =
            ViewModelProviders.of(fragmentActivity, viewModelFactory).get(clazz)

    fun getNeToDoApp(): NeToDoApp = application as NeToDoApp
}