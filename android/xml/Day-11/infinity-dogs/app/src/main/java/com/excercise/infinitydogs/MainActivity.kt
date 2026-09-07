package com.excercise.infinitydogs

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.excercise.infinitydogs.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://dog.ceo")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val callable = retrofit.create(DogAPICallable::class.java)
        callable.getData().enqueue(object : Callback<DogModel> {
            override fun onResponse(call: Call<DogModel?>, response: Response<DogModel?>) {
                if(response.isSuccessful){
                    val dog = response.body()
                    Glide
                        .with(this@MainActivity)
                        .load(dog?.imageURL)
                        .into(binding.dogIv)
                }
            }

            override fun onFailure(call: Call<DogModel?>, t: Throwable) {
                Log.d("trace","Error: ${t.message}")
            }
        })

    }
}