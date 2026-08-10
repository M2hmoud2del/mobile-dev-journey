package com.example.picksart

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

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


        val image: ImageView = findViewById(R.id.selected_image_view)
        val closeCV: CardView = findViewById(R.id.close_image_container_cv)

        val contract = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            if (it != null){
                image.setImageURI(it)
                closeCV.isVisible = true
            }
        }

        image.setOnClickListener {
            contract.launch(PickVisualMediaRequest())
        }

        closeCV.setOnClickListener {
            image.setImageURI(null)
            closeCV.isVisible = false
        }


    }
}