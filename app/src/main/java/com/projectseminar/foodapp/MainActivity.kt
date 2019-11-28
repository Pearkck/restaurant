package com.projectseminar.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat

import com.google.android.material.navigation.NavigationView
import android.view.Gravity
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.projectseminar.foodapp.Model.Restaurant
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navbar: NavigationView
    lateinit var fragment: Fragment
    var restaurantData : Restaurant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this
            ,drawerLayout
            ,R.string.open_drawer
            ,R.string.close_drawer)
        navbar = findViewById(R.id.nav_view)
        navbar.setNavigationItemSelectedListener(this)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        showmenu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT)
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT)
            }
        }
//        showfilter.setOnClickListener {
//            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
//                drawerLayout.closeDrawer(Gravity.LEFT)
//            } else {
//                drawerLayout.openDrawer(Gravity.LEFT)
//            }
//        }
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, GalleryFragment()).commit();
        }

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.43.253:8081/getRestaurants/"
        val stringRequest = JsonArrayRequest(Request.Method.POST, url, null,
            Response.Listener { response ->
                Log.d("Test API:", response.toString())
//                for (item in 0..response.length()) {
//                    Log.d("response",response[0].toString())
//                }


            },
            Response.ErrorListener { error ->
                Log.d("Test API:", error.toString())
            })
        queue.add(stringRequest)

    }


//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        if (actionBarDrawerToggle.onOptionsItemSelected(item))
//            return true
//        return super.onOptionsItemSelected(item)
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.signup -> {
                Toast.makeText(this,"signup",Toast.LENGTH_SHORT).show()
            }
            R.id.signin -> {
                Toast.makeText(this,"signin",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gallery -> {
                Toast.makeText(this,"gallery",Toast.LENGTH_SHORT).show()
                fragment = GalleryFragment()
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, fragment).addToBackStack(null).commit();
            }
            R.id.nav_home -> {
                Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
                fragment = RestaurantMainFragment()
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, fragment).addToBackStack(null).commit();
            }
        }
        drawerLayout.closeDrawer(GravityCompat.END);
        return super.onOptionsItemSelected(item)
    }

}
