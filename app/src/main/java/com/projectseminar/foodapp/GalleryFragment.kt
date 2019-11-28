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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.mancj.materialsearchbar.MaterialSearchBar
import com.projectseminar.foodapp.Adapter.MainAdapter
import com.projectseminar.foodapp.Adapter.RestaurantAdapter
import com.projectseminar.foodapp.Model.Restaurant
import org.json.JSONObject

class GalleryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var data = DataProvider.getData()
    private lateinit var mcontext : Context
    private lateinit var Adapter : RestaurantAdapter
    var mUserItems :ArrayList<Int>? = null
    var lastCheckedItem =  booleanArrayOf(false,false,false,false,false,false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context != null) {
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
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val recycler_view = root.findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val adapter = MainAdapter(context, data)
        recycler_view.adapter = adapter
        return root
    }


}
