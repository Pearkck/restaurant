package com.projectseminar.foodapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mancj.materialsearchbar.MaterialSearchBar
import com.projectseminar.foodapp.Adapter.RestaurantAdapter
import com.projectseminar.foodapp.Model.Restaurant

class RestaurantMainFragment : Fragment() {
    private var data = DataProvider.getData()
    private lateinit var mcontext : Context
    private lateinit var Adapter : RestaurantAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context != null) {
            Log.d("mcontext","aaaaa")
            mcontext = context
            Adapter = RestaurantAdapter(mcontext,data)
        } else {
            throw ClassCastException(context.toString() + " must implement OnDogSelected.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var intent = Intent(activity,RestaurantDetailActivity::class.java)
        val root = inflater.inflate(R.layout.fragment_restaurant_main, container, false)
        var searchbar = root.findViewById<MaterialSearchBar>(R.id.searchBar)
        searchbar.addTextChangeListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
//
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("textchange",s.toString())
                searching(s.toString())
            }

        })

        var list = root.findViewById<RecyclerView>(R.id.restaurant_list)
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = Adapter
        return root
    }

    fun searching(searchtxt: String){
        Log.d("textchange","ss")
        var searchedData = arrayListOf<Restaurant>()
        for (item in data){
            if (searchtxt==""){
                searchedData = data
                break
            }
            if(item.restaurantName.toLowerCase().contains(searchtxt.toLowerCase())){
                searchedData.add(item)
            }
        }
        Adapter.setNotify(searchedData)
    }
}
