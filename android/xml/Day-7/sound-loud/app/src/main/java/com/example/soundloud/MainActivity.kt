package com.example.soundloud

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playBtn: Button = findViewById(R.id.play_btn)
        val pauseBtn: Button = findViewById(R.id.pause_btn)
        val stopBtn: Button = findViewById(R.id.stop_btn)

        media = MediaPlayer.create(this,R.raw.sound)

        playBtn.setOnClickListener { media.start() }

        pauseBtn.setOnClickListener { media.pause() }

        stopBtn.setOnClickListener {
            media.stop()
            media.prepareAsync()
        }

    }

    override fun onPause() {
        super.onPause()
        media.release()
    }
}