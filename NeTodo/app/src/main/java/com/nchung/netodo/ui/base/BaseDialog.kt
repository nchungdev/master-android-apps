package com.nchung.netodo.ui.base

import android.content.Context
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialog<VM : BaseViewModel> : DialogFragment() {

    var baseActivity: BaseActivity<*>? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun bindViews(view: View? = null)

    abstract fun getViewModel(): VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            baseActivity = context
            baseActivity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
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
    }

    companion object {
        private val TAG = this::class.java.simpleName
    }
}
