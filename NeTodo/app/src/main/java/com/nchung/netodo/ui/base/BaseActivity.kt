package com.nchung.netodo.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.nchung.netodo.di.ViewModelFactory
import com.nchung.netodo.utils.NetworkUtils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : DaggerAppCompatActivity(), BaseFragment.Callback {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun bindViews()

    abstract fun getViewModel(): VM

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
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