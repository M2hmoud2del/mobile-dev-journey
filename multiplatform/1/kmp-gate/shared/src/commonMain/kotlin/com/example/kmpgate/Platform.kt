package com.example.kmpgate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform