package com.maadcoding.bedtimestories

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class StoryActivity : AppCompatActivity() {

    private lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titleTV: TextView = findViewById(R.id.title_tv)
        val detailsTV: TextView = findViewById(R.id.details_tv)
        val storyIV: ImageView = findViewById(R.id.story_iv)

        titleTV.setText(intent.getIntExtra("title", -1))
        detailsTV.setText(intent.getIntExtra("details", -2))
        storyIV.setImageResource(intent.getIntExtra("picture", -3))

        media = MediaPlayer
            .create(this, intent.getIntExtra("sound", -4))
        media.start()

        lifecycleScope.launch {
           val savedSize = dataStore.data.first()[UserPreferences.TEXT_SIZE_KEY]?.toFloat() ?: 16.0f
            detailsTV.textSize = savedSize
            Log.d("trace", "Size: $savedSize")
        }

    }

    override fun onPause() {
        super.onPause()
        media.release()
    }


}