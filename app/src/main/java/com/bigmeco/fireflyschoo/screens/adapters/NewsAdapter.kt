package com.bigmeco.fireflyschoo.screens.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.NewsPojo

class NewsAdapter(val items: ArrayList<NewsPojo>, val listener: (id: Int) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NewsPojo, listener: (id: Int) -> Unit) = with(itemView) {

        }

    }
}
