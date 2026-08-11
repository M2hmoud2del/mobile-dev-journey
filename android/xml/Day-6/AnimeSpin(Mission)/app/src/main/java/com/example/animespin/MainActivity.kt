package com.example.animespin

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
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
    var isFirstSelection = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val spinner: Spinner = findViewById(R.id.anime_spinner)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            animeList
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this


    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        if(isFirstSelection){
            isFirstSelection = false
            return
        }
        val URL = "https://www.google.com/search?q=" + animeList[pos]

        val i = Intent(Intent.ACTION_VIEW, Uri.parse(URL))

        try {
            startActivity(i)
        }catch(e : ActivityNotFoundException){
            Toast.makeText(this, "No browser application found.", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, animeList[pos], Toast.LENGTH_SHORT).show();
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback.
    }
}