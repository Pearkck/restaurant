package com.projectseminar.foodapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projectseminar.foodapp.R
import kotlinx.android.synthetic.main.restaurant_review_layout.view.*

class ReviewAdapter  (val mContext: Context) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    val data = listOf<Int>(R.drawable.yours_dessert_bar, R.drawable.anya, R.drawable.chateau, R.drawable.chengsimei)
    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {

//        holder.itemView.imageView2.setImageResource(data[position%4])
        holder.itemView.review_user.text = "Bobby Tom"
        holder.itemView.review_text.text = "Very good"
//        holder.itemView.review_text.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in lectus tincidunt, sagittis enim ut, ullamcorper lectus. Duis nec dui ac urna molestie congue id a diam. Sed dapibus neque sit amet odio facilisis, vel accumsan libero imperdiet. Mauris id massa justo. In lobortis odio eu ipsum ultricies, sit amet euismod mi consequat. Aliquam at pulvinar orci. Suspendisse blandit malesuada rutrum. Curabitur eleifend pretium nunc quis sollicitudin. Vestibulum ac dictum felis. Integer pulvinar cursus felis faucibus accumsan.\n" +
//                "\n" +
//                "Phasellus maximus, mauris in maximus accumsan, nisi tellus fermentum leo, vitae blandit libero nunc vitae massa. Sed eu cursus dolor. Suspendisse mattis id urna non eleifend. Mauris eu purus augue. Nam fringilla blandit enim. Maecenas vel hendrerit mauris, eu euismod sapien. Morbi congue elementum massa eget feugiat. Phasellus mollis nunc velit, non pharetra nibh lacinia in. Sed non dolor vestibulum, consequat magna vel, mollis felis.\n" +
//                "\n" +
//                "Suspendisse nisl risus, pharetra commodo lectus eget, lacinia semper lorem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla ultricies bibendum sem vel convallis. Sed porta scelerisque tellus, a varius ipsum elementum non. Pellentesque in efficitur lorem. Fusce sit amet magna id ante elementum luctus sed nec orci. In quis tortor quis tortor feugiat scelerisque nec laoreet turpis.\n" +
//                "\n" +
//                "Pellentesque ultrices odio ac orci tempor, sit amet interdum nisi facilisis. Praesent ac mollis tortor, a dignissim velit. Nam aliquet ultricies turpis id molestie. Aliquam ut leo quis dui euismod faucibus a ac neque. Proin ultricies pretium tristique. Fusce in est eget risus pharetra placerat eu vel enim. Donec a orci elit. Fusce non neque tempor, posuere massa at, mattis magna. Aliquam eu odio ut lorem cursus rhoncus. Donec quis dolor a ligula pharetra volutpat mollis ut nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum velit lorem, pellentesque a dignissim ac, placerat quis velit. In rhoncus rhoncus dolor vitae auctor. Mauris sit amet fringilla nisl. Curabitur faucibus rutrum urna nec commodo.\n" +
//                "\n" +
//                "Nunc pretium magna tellus, id tristique leo feugiat sit amet. Praesent lacinia semper dapibus. Phasellus euismod arcu magna, sed venenatis quam fermentum nec. Nullam a sapien quam. Curabitur turpis sapien, ultricies ac commodo in, ultricies ut elit. Integer eget luctus felis. Etiam vehicula tempor hendrerit. Sed rutrum ultrices nisl vel volutpat."
        holder.itemView.review_date.text = "24/11/2019"
        holder.itemView.review_rating.rating = 1.toFloat()

//        holder.itemView.setOnClickListener {
//            val intent = Intent(mContext, RestaurantDetailActivity::class.java)
//
//            intent.putExtra("RestaurantImage",data[position].restaurantImage)
//            intent.putExtra("RestaurantName",data[position].restaurantName)
//            intent.putExtra("RestaurantRate",data[position].restaurantRate)
//            intent.putExtra("RestaurantType",data[position].getType())
//            mContext.startActivity(intent)
//        }

//        holder.imageName = data[position].restaurantName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_review_layout, parent, false))
    }

//    fun setNotify(searchedData:ArrayList<Restaurant>){
//        data = searchedData
//        notifyDataSetChanged()
//    }

    class ReviewViewHolder(v : View) : RecyclerView.ViewHolder(v)

}