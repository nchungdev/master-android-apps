package com.nchung.netodo.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected val items = arrayListOf<T>()

    override fun getItemCount() = items.size

    fun getItem(position: Int) = items[position]

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun update(position: Int, item: T) {
        items.add(position, item)
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun remove(item: T) {
        items.remove(item)
        notifyDataSetChanged()
    }
}
