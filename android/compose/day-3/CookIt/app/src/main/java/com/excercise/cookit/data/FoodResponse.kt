package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class FoodResponse (
    @SerializedName("meals")
    val foods: List<FoodModel>
)