package com.nchung.ne.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    val items = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(layoutInflater.inflate(R.layout.layout_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindData(items[position])
    }

    fun getViewHolder() {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        private val tvInside = itemView.findViewById<TextView>(R.id.tvInside)
        private val tvOutside = itemView.findViewById<TextView>(R.id.tvOutside)

        fun bindData(item: Item) {
            Glide.with(itemView)
                    .asGif()
                    .load("https://yesno.wtf/assets/no/4-122be48db47678331dbef3dd6ac6ff56.gif")
                    .into(imageView)
            val avg = 409 - (409 - 264) / 2
            if (itemView.height < avg) collapsed()
            else expanded()
        }

        fun collapsed() {
            tvOutside.visibility = View.GONE
            tvInside.visibility = View.VISIBLE
        }

        fun expanded() {
            tvOutside.visibility = View.VISIBLE
            tvInside.visibility = View.GONE
        }

    }
}
