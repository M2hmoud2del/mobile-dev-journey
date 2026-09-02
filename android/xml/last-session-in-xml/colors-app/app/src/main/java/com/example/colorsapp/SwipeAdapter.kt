package com.example.colorsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SwipeAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RedFragment()
            1 -> GreenFragment()
            else -> BlueFragment()
        }
    }

    override fun getItemCount() = 3
}