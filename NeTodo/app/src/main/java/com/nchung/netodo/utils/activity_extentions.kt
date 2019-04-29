package com.nchung.netodo.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


fun Activity.hideKeyboard() {
    this.currentFocus?.let { view ->
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?).also {
            it?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}

fun FragmentActivity.replaceFragment(idContainer: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(idContainer, fragment)
            .commit()
}