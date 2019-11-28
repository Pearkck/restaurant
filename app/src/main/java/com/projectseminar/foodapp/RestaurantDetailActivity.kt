package com.projectseminar.foodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectseminar.foodapp.Adapter.ImageAdapter
import com.projectseminar.foodapp.Adapter.ReviewAdapter
import com.projectseminar.foodapp.Model.Restaurant
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetailActivity : AppCompatActivity() {

    val data = DataProvider.getData()
    var res_data = arrayListOf<Restaurant>()
    val oprhrs = arrayOf("11:00 - 21:00", "11:00 - 21:00", "11:00 - 21:00", "11:00 - 21:00", "11:00 - 21:00", "11:00 - 21:00", "11:00 - 21:00")

    private val image_adapter = ImageAdapter(this)
    private val review_adapter = ReviewAdapter(this)

    private fun getOprHrs(): String{
        var OprHrs = ""
        var i = 0
        var type = ""
        while (i < oprhrs.size){
            if (i == 0){
                OprHrs = oprhrs[i]
            }
            else{
                OprHrs = OprHrs + "\n" + oprhrs[i]
            }
            i = i+1
        }
        return OprHrs
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        val image = intent.getIntExtra("RestaurantImage", 0)
        val name = intent.getStringExtra("RestaurantName")
        val rate = intent.getDoubleExtra("RestaurantRate",0.0)
        val type = intent.getStringExtra("RestaurantType")

        res_data.clear()
        for (item in data){
            if(item.restaurantName.toLowerCase().contains(name.toLowerCase())){
                res_data.add(item)
                break
            }
        }


        imageView4.setImageResource(res_data[0].restaurantImage)
        res_name.text = res_data[0].restaurantName
        res_rate.text = res_data[0].restaurantRate.toString()
        res_type.text = res_data[0].getType()

        res_operating_hours.text = getOprHrs()

        image_recyclerView.layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        image_recyclerView.adapter = image_adapter

        review_recyclerView.layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        review_recyclerView.adapter = review_adapter

        addReviewBtn.setOnClickListener {
            val add_review_intent = Intent(this, AddReviewActivity::class.java)
            startActivity(add_review_intent)
        }
    }
}