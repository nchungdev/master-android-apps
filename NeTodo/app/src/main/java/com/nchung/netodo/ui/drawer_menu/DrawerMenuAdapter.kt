package com.nchung.netodo.ui.drawer_menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.nchung.netodo.R
import com.nchung.netodo.ui.base.BaseAdapter
import com.nchung.netodo.ui.base.BaseViewHolder

class DrawerMenuAdapter : BaseAdapter<DrawerMenuItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DrawerMenuItem> {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task_list, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<DrawerMenuItem>, position: Int) {
        holder.bindViews(getItem(position))
    }

    class ViewHolder(itemView: View) : BaseViewHolder<DrawerMenuItem>(itemView) {
        override fun bindViews(item: DrawerMenuItem) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val tvBadge = itemView.findViewById<TextView>(R.id.tv_badge)
            tvTitle.setText(item.titleId)
            tvTitle.setCompoundDrawablesRelative(ContextCompat.getDrawable(itemView.context, item.iconId), null, null, null)
            tvBadge.text = item.badge.toString()
        }
    }
}
