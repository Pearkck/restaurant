package com.projectseminar.foodapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_image.*
import kotlinx.android.synthetic.main.activity_add_image.*
import kotlinx.android.synthetic.main.activity_add_review.*
import java.io.IOException
import java.lang.Exception

class addImageActivity: AppCompatActivity() {
    private val PICK_IMAGE_MULTIPLE = 1
    private val PICK_IMAGE_REQUEST = 1
    private var filePath: Uri? = null
    lateinit var imageEncoded: String
    lateinit var imageEncodedList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_image)
        selected_imageView.visibility = View.GONE
        finishSelectImgBtn.visibility = View.GONE
        selectImgBtn.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE)
        }
        finishSelectImgBtn.setOnClickListener {
            Toast.makeText(this, "finish",Toast.LENGTH_LONG).show()
            finish()
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        try {
//            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data){
//                var filePathColumn = {
//                    MediaStore.Images.Media.DATA
//                }
//                imageEncodedList = arrayListOf<String>()
//                if(data.data != null){
//                    val mImageUri = data.data
//                    val cursor = contentResolver.query(mImageUri!!, filePathColumn, null, null, null)
//                    cursor!!.moveToFirst()
//                    val columnIndex = cursor.getColumnIndex(filePathColumn[0])
//                }
//            }
//
//        } catch (e: Exception){
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null){
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                selected_imageView.visibility = View.VISIBLE
                finishSelectImgBtn.visibility = View.VISIBLE
                selected_imageView.setImageBitmap(bitmap)
            } catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
}