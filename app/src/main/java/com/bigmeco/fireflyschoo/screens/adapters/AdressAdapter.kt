package com.bigmeco.fireflyschoo.screens.adapters

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.AdressPojo
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.models.implementation.ImageLoadingModel
import kotlinx.android.synthetic.main.item_adress.view.*
import kotlinx.android.synthetic.main.item_news.view.*


class AdressAdapter(val items: ArrayList<AdressPojo>, val listener: (id: Int) -> Unit) : RecyclerView.Adapter<AdressAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_adress, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AdressPojo, listener: (id: Int) -> Unit) = with(itemView) {
            textAdress.text = item.adress
            textAdress.setOnClickListener {
                context?.let { context ->
                    val map = Uri.parse("geo:0,0?q=" + item.adress.toString())
                    val intent = Intent(Intent.ACTION_VIEW, map)
                    val packageManager = context.packageManager
                    val activities = packageManager.queryIntentActivities(intent, 0)
                    val isIntentSafe = activities.size > 0
                    if (isIntentSafe) {
                        context.startActivity(intent)
                    }
                }
            }

    }
}
}

