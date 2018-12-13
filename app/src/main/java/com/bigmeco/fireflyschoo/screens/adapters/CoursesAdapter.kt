package com.bigmeco.fireflyschoo.screens.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.models.implementation.ImageLoadingModel
import kotlinx.android.synthetic.main.item_courses.view.*


class CoursesAdapter(val items: ArrayList<CoursesPojo>, val listener: (item: CoursesPojo) -> Unit) : RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_courses, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CoursesPojo, listener: (item: CoursesPojo) -> Unit) = with(itemView) {

            if (item.image != null  && item.image != "") {
                ImageLoadingModel().urlToImage(item.image!!) {
                //    imageCourses.setImageBitmap(it)
                }
            }

            textTitel.text = item.title
            itemCourses.setBackgroundColor(Color.parseColor(item.color))

            itemCourses.setOnClickListener {
                listener.invoke(item)
            }
        }

    }
}
