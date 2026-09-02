package com.example.colorsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.colorsapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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


        val adapter = SwipeAdapter(this)
        binding.viewPager.adapter = adapter

        val names = arrayOf("Red","Green","Blue")

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, pos ->
            tab.text = names[pos]
        }.attach()






//        binding.greenBtn.setOnClickListener { changeFragment(GreenFragment()) }
//
//        binding.blueBtn.setOnClickListener { changeFragment(BlueFragment()) }
    }

//    fun changeFragment(fragment: Fragment) {
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.fragment_container_view,fragment)
//        transaction.commit()
//    }
}