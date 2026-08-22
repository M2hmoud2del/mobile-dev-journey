package com.maadcoding.bedtimestories

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
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

        val stories = mutableListOf<Story>()
        stories.add(
            Story(
                R.string.bee_grasshopper_title,
                R.string.bee_grasshopper_story,
                R.drawable.bee_grasshopper,
                R.raw.bee,

                )
        )
        stories.add(
            Story(
                R.string.hungry_cat_title,
                R.string.hungry_cat_story,
                R.drawable.hungry_cat,
                R.raw.cat,
            )
        )
        stories.add(
            Story(
                R.string.chicken_little_title,
                R.string.chicken_little_story,
                R.drawable.chicken_little,
                R.raw.chick,
            )
        )
        stories.add(
            Story(
                R.string.lucky_ducky_title,
                R.string.lucky_ducky_story,
                R.drawable.lucky_ducky,
                R.raw.duck,
            )
        )

        val list: ListView = findViewById(R.id.stories_list)
        val settingsIV: ImageView = findViewById(R.id.settings_iv)

        settingsIV.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        val adapter = ArrayAdapter(
            this,
            R.layout.story_list_item,
            stories.map { getString(it.title) }
        )

        list.adapter = adapter

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val i = Intent(this, StoryActivity::class.java)
            i.putExtra("title", stories[position].title)
            i.putExtra("details", stories[position].story)
            i.putExtra("picture", stories[position].picture)
            i.putExtra("sound", stories[position].sound)
            startActivity(i)
        }



    }
}

