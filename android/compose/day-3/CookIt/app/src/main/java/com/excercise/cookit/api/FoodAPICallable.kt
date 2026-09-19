package com.excercise.cookit.api

import com.excercise.cookit.data.ApiConstants
import com.excercise.cookit.data.CategoryResponse
import com.excercise.cookit.data.FoodModel
import com.excercise.cookit.data.FoodResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPICallable {
    @GET(ApiConstants.CATEGORIES_ENDPOINT)
    suspend fun getCategoryData(): CategoryResponse

    @GET(ApiConstants.FILTER_ENDPOINT)
    suspend fun getFoodByCategory(
        @Query(ApiConstants.CATEGORY_QUERY) category: String
    ): FoodResponse
}