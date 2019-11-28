package com.projectseminar.foodapp.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projectseminar.foodapp.R
import kotlinx.android.synthetic.main.restaurant_image_recycler_layout.view.*

class ImageAdapter (val mContext: Context) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val data = listOf<Int>(R.drawable.yours_dessert_bar, R.drawable.anya, R.drawable.chateau, R.drawable.chengsimei)

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        if(position == 3){
            holder.itemView.imageView2.setBackgroundColor(Color.GRAY)
        }
        else holder.itemView.imageView2.setImageResource(data[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_image_recycler_layout, parent, false))
    }

//    fun setNotify(searchedData:ArrayList<Restaurant>){
//        data = searchedData
//        notifyDataSetChanged()
//    }

    class ImageViewHolder(val v : View) : RecyclerView.ViewHolder(v)

}