package com.nchung.nepic.ui.base

import android.annotation.TargetApi
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.nchung.nepic.di.ViewModelFactory
import com.nchung.nepic.utils.NetworkUtils
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel<*>> :
    AppCompatActivity(),
    ActivityBehavior<VM>,
    BaseFragment.Callback {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setupNavigator()
        bindViews()
    }

    fun hideKeyboard() {
        this.currentFocus?.let { view ->
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?).also {
                it?.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    fun <T : ViewModel> getViewModel(activity: FragmentActivity, clazz: Class<T>): T =
        ViewModelProviders.of(activity, viewModelFactory).get(clazz)

    override fun onFragmentAttached() = Unit

    override fun onFragmentDetached(tag: String) = Unit

    fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }
}