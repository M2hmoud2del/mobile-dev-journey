package com.excercise.cookit.api

import com.excercise.cookit.data.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {  Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        }
    val foodAPI = retrofit.create(FoodAPICallable::class.java)
}