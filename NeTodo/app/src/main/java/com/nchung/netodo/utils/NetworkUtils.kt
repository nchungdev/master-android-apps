package com.nchung.netodo.utils

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {
    @JvmStatic
    fun isNetworkConnected(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?)?.let {
            it.activeNetworkInfo?.isConnected ?: false
        } ?: false
}
