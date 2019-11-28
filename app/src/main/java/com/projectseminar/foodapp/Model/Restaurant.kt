package com.projectseminar.foodapp.Model

class Restaurant(val restaurantImage: Int, val restaurantName: String, val restaurantRate: Double, val restaurantType: Array<String>, val restaurantMinPrice: Int, val restaurantMaxPrice: Int, val restaurantReviewAmount: Int, val imgurl: String) {
    fun getType(): String{
        var i = 0
        var type = ""
        while (i < restaurantType.size){
            if (i == 0){
                type = restaurantType[i]
            }
            else{
                type = type+", "+ restaurantType[i]
            }
            i = i+1
        }
        return type
    }
}