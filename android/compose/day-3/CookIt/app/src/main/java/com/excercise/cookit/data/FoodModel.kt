package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class FoodModel (
    @SerializedName("idMeal")
    val id: String = "",

    @SerializedName("strMeal")
    val name: String = "",

    @SerializedName("strMealThumb")
    val imageURL: String = "",
)