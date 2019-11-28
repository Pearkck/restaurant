package com.projectseminar.foodapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.projectseminar.foodapp.Model.Restaurant
import com.projectseminar.foodapp.R
import com.projectseminar.foodapp.RestaurantDetailActivity
import kotlinx.android.synthetic.main.restaurant_item_layout.view.*

class MainAdapter(val mContext: Context?, val data : ArrayList<Restaurant>) :
    RecyclerView.Adapter<MainAdapter.RestaurantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val cellForRow = layoutInflater.inflate(R.layout.image_item, parent, false)
//        return RestaurantViewHolder(cellForRow)
        return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

//        var blog_image = holder.itemView.res_image
//        val url = "localhost:8081/food/"+ data[position].imageName
//        val url = "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png"
//        val url = "https://https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/"+data[position].imgurl
        val url = data[position].imgurl

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(holder.itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(url)
            .into(holder.itemView.res_image)

//        holder.restaurantName = data[position].restaurantName
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, RestaurantDetailActivity::class.java)
            intent.putExtra("RestaurantName",data[position].restaurantName)
            mContext!!.startActivity(intent)
        }
    }

    class RestaurantViewHolder(val v : View) : RecyclerView.ViewHolder(v)
}