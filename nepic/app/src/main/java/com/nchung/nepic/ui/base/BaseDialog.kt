package com.nchung.nepic.ui.base

import android.content.Context
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

abstract class BaseDialog<VM : BaseViewModel<*>> : DialogFragment(), FragmentBehavior<VM> {

    var baseActivity: BaseActivity<*>? = null

    fun isNetworkConnected() = baseActivity?.isNetworkConnected() ?: false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            baseActivity = context
            baseActivity?.onFragmentAttached()
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    fun show(fragmentManager: FragmentManager) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(TAG)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, TAG)
    }

    fun dismissDialog() {
        dismiss()
        baseActivity?.onFragmentDetached(TAG)
    }

    fun hideKeyboard() {
        baseActivity?.hideKeyboard()
    }

    companion object {
        private val TAG = this::class.java.simpleName
    }
}
