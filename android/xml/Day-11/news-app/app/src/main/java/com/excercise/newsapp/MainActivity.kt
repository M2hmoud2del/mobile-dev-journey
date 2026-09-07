package com.excercise.newsapp

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.excercise.newsapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

//        GET https://newsapi.org
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    loadNews()

        binding.articleSR.setOnRefreshListener {
            loadNews()
        }
    }

    private fun loadNews(){
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsCallable::class.java)
        retrofit.getData().enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                if(response.isSuccessful){
                    val news = response.body()
                    val articles = news?.articles!!
                    Log.d("data","Articles: $articles")
                    showNews(articles)
                    binding.progress.isVisible = false
                    binding.articleSR.isRefreshing = false
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                binding.progress.isVisible = false
                binding.articleSR.isRefreshing = false
                Log.d("trace","Error: ${t.message}")
                Snackbar
                    .make(binding.root,"No Internet Connection !", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Open Settings"){
                        val i = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                        startActivity(i)
                    }
                    .show()
            }
        })
    }

    private fun showNews(articles: ArrayList<Article>){
        val adapter = NewsAdapter(this, articles)
        binding.articlesRV.adapter = adapter


    }
}