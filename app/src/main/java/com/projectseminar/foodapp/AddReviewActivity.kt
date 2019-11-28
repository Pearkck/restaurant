package com.projectseminar.foodapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_review.*

class AddReviewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_review)

//        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        addImageInReviewBtn.setOnClickListener {
            val add_image_intent = Intent(this, addImageActivity::class.java)
            startActivity(add_image_intent)
        }
    }
}