package com.example.waitforit

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentUser = 1
    var score1 = 0
    var score2 = 0
    var currentSpeed = 1
    var currentLight = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tapBtn : Button = findViewById(R.id.btnTap)
        val currentPlayerNameTV : TextView = findViewById(R.id.tvPlayerTurn)
        val scoreTV : TextView = findViewById(R.id.tvScore)
        val ligtsCV : Array<CardView> = arrayOf(
            findViewById(R.id.light1),
            findViewById(R.id.light2),
            findViewById(R.id.light3),
            findViewById(R.id.light4)
        )
        tapBtn.setOnClickListener {
            tapBtn.text = "Game Started"
            tapBtn.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#000"))
            currentPlayerNameTV.text = "Player $currentUser"
            updateScore(scoreTV)
        }
    }
    fun updateScore(scoreTV : TextView) {
        val regex = Regex("[0-9]+")
        when(currentUser){
            1 -> scoreTV.text = regex.replace(scoreTV.text, this.score1.toString())
            2 -> scoreTV.text = regex.replace(scoreTV.text, this.score2.toString())
        }

    }
}