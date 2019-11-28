package com.projectseminar.foodapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projectseminar.foodapp.Model.Restaurant
import com.projectseminar.foodapp.R
import com.projectseminar.foodapp.RestaurantDetailActivity
import kotlinx.android.synthetic.main.restaurant_item_layout.view.*

class RestaurantAdapter(val mContext: Context, var data : ArrayList<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
//        val rate = data[position].restaurantRate
//        if(rate >= 4.0){
//            //สีแดง
//            holder.itemView.res_rate_cardview.setBackgroundColor(Color.parseColor("#ff0000"))
//        }else if (rate >= 3.0){
//            //สีแดงส้ม
//            holder.itemView.res_rate_cardview.setBackgroundColor(Color.parseColor("#ff4000"))
//        }else if (rate >= 2.0){
//            //สีเหลืองส้ม
//            holder.itemView.res_rate_cardview.setBackgroundColor(Color.parseColor("#ff9100"))
//        }else if (rate >= 1.0){
//            //สีเหลือง
//            holder.itemView.res_rate_cardview.setBackgroundColor(Color.parseColor("#ffc800"))
//        }
//        holder.itemView.res_rate_cardview.radius = 10F
        holder.itemView.res_image.setImageResource(data[position].restaurantImage)
        holder.itemView.res_name.text = data[position].restaurantName
        holder.itemView.res_rate.text = data[position].restaurantRate.toString()
        holder.itemView.res_type.text = data[position].getType()
        holder.itemView.res_price.text = "ราคา: "+data[position].restaurantMinPrice.toString()+" - "+data[position].restaurantMaxPrice.toString()+" บาท"
        holder.itemView.res_review_amount.text = "รีวิว: "+data[position].restaurantReviewAmount.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, RestaurantDetailActivity::class.java)
            intent.putExtra("RestaurantName",data[position].restaurantName)
            mContext.startActivity(intent)
        }

//        holder.imageName = data[position].restaurantName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item_layout, parent, false))
    }

    fun setNotify(searchedData:ArrayList<Restaurant>){
        data = searchedData
        notifyDataSetChanged()
    }

    class RestaurantViewHolder(val v : View) : RecyclerView.ViewHolder(v)

}