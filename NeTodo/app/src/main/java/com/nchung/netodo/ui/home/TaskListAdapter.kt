package com.nchung.netodo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseAdapter
import com.nchung.netodo.ui.base.BaseViewHolder

class TaskListAdapter : BaseAdapter<TaskListAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task_list, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder<TaskListAdapter>, position: Int) {
        holder.bindViews(getItem(position))
    }

    class ViewHolder(itemView: View) : BaseViewHolder<TaskListAdapter>(itemView) {
        override fun bindViews(item: TaskListAdapter) {

        }
    }
}