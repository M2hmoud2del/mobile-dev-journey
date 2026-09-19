package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class FoodModel (
    @SerializedName(ApiConstants.FOOD_ID)
    val id: String = "",

    @SerializedName(ApiConstants.FOOD_NAME)
    val name: String = "",

    @SerializedName(ApiConstants.FOOD_IMAGE)
    val imageURL: String = "",
)