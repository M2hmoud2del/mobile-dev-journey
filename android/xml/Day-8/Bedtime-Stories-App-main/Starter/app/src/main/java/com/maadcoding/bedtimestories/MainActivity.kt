package com.maadcoding.bedtimestories

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
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

        stories.add(Story(
            R.string.hungry_cat_title,
            R.string.hungry_cat_story,
            R.drawable.hungry_cat,
            R.raw.cat
        ))
        stories.add(Story(
            R.string.lucky_ducky_title,
            R.string.lucky_ducky_story,
            R.drawable.lucky_ducky,
            R.raw.duck
        ))
        stories.add(Story(
            R.string.chicken_little_title,
            R.string.chicken_little_story,
            R.drawable.chicken_little,
            R.raw.chick
        ))
        stories.add(Story(
            R.string.bee_grasshopper_title,
            R.string.bee_grasshopper_story,
            R.drawable.bee_grasshopper,
            R.raw.bee
        ))

        val adapter = ArrayAdapter(
            this,
            R.layout.story_list_item,
            stories.map { getString( it.title )  },
        )


        val storiesLV : ListView = findViewById(R.id.stories_list)
        val settingsBtn : ImageView = findViewById(R.id.settings_iv)

        storiesLV.adapter = adapter

        storiesLV.setOnItemClickListener { x , y , pos , z ->
            val i = Intent(this, StoryActivity::class.java)
            i.putExtra("title", stories[pos].title)
            i.putExtra("details", stories[pos].details)
            i.putExtra("picture", stories[pos].pic)
            i.putExtra("sound", stories[pos].sound)

            startActivity( i )
        }

        settingsBtn.setOnClickListener {
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
        }
    }

}

