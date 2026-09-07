package com.excercise.newsapp

import retrofit2.Call
import retrofit2.http.GET

interface NewsCallable {
    @GET("/v2/top-headlines?country=us&category=general&pageSize=30&apiKey=86e8bb8fb7854064b88895e38456a57f")
    fun getData(): Call<News>
}