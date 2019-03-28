package com.nchung.netodo.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    private val items = arrayListOf<T>()

    override fun getItemCount() = items.size

    fun getItem(position: Int) = items[position]

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
    }

    fun addItem(item: T) = items.add(item)

    fun update(position: Int, item: T) = items.add(position, item)

    fun remove(position: Int) = items.removeAt(position)

    fun remove(item: T) = items.remove(item)
}
