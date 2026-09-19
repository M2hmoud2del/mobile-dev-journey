package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class CategoryModel (

    @SerializedName(ApiConstants.CATEGORY_ID)
    val id: String = "",

    @SerializedName(ApiConstants.CATEGORY_NAME)
    val name: String = "",

    @SerializedName(ApiConstants.CATEGORY_IMAGE)
    val imageURL: String = ""
)