package com.excercise.findingnemo

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image : ImageView = findViewById(R.id.image)
        Glide
            .with(this)
            .load("https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExdGQyanoyZGl6cjgzZnRtcGR1Z3Rya3Ntb25lMDR5dzU3YmJwa2k3NyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/109RutRrTGY97a/giphy.gif")
            .placeholder(R.drawable.loading)
            .error(Color.BLACK.toDrawable())
            .into(image)
    }
}