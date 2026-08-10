package com.example.animelist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val animeList = arrayOf(
            "Hunter X Hunter",
            "Dragon Ball",
            "Death Note",
            "One Piece",
            "Attack on Titan",
            "One Punch Man",
            "Pokémon",
            "Parasyte: The Maxim",
            "Naruto Shippuden",
            "Jujutsu Kaisen",
            "Bleach",
            "Solo Leveling",
            "Demon Slayer",
            "My Hero Academia",
            "Spirited Away",
            "My Neighbor Totoro",
            "Kiki’s Delivery Service",
            "Ponyo",
            "The Cat Returns",
            "Arrietty",
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            animeList)

        val list : ListView = findViewById(R.id.anime_lv)

        list.adapter = adapter

        list.setOnItemClickListener { x , y, position, z ->
            Toast.makeText(this, animeList[position], Toast.LENGTH_SHORT).show();
        }
    }
}