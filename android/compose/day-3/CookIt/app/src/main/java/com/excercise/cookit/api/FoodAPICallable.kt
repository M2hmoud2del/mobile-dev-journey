package com.excercise.cookit.api

import com.excercise.cookit.data.CategoryResponse
import com.excercise.cookit.data.FoodModel
import com.excercise.cookit.data.FoodResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://www.themealdb.com
//     /api/json/v1/1/categories.php , /api/json/v1/1/filter.php?c=Seafood
interface FoodAPICallable {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategoryData(): CategoryResponse

    @GET("api/json/v1/1/filter.php")
    suspend fun getFoodByCategory(
        @Query("c") category: String
    ): FoodResponse
}