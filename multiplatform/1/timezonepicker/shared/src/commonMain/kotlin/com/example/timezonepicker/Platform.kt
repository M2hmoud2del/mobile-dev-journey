package com.example.timezonepicker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform