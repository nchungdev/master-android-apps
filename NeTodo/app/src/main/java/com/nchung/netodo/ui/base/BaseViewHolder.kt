package com.nchung.netodo.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
        parent: ViewGroup,
        @LayoutRes layoutRes: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {
    abstract fun bindViews(item: T)

    abstract fun setOnClickListener(onItemClickListener: OnItemClickListener)

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }
}
