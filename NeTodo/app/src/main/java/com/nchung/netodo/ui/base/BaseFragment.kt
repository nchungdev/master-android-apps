package com.nchung.netodo.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.nchung.netodo.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : DaggerFragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun bindViews(view: View? = null)

    abstract fun getViewModel(): VM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(getLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
    }

    fun <T : ViewModel> getViewModel(fragment: Fragment, clazz: Class<T>): T =
            ViewModelProviders.of(fragment, viewModelFactory).get(clazz)

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}
