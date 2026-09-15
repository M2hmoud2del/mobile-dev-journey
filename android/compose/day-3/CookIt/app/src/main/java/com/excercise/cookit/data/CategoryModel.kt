package com.excercise.cookit.data

import com.google.gson.annotations.SerializedName

class CategoryModel (

    @SerializedName("idCategory")
    val id: String = "",

    @SerializedName("strCategory")
    val name: String = "",

    @SerializedName("strCategoryThumb")
    val imageURL: String = ""
)