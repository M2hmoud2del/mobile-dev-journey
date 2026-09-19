package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class FoodResponse (
    @SerializedName(ApiConstants.FOODS)
    val foods: List<FoodModel>
)