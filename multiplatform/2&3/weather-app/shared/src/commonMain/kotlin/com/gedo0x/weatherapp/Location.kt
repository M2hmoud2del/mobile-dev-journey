package com.gedo0x.weatherapp

import androidx.compose.runtime.Composable


data class Location(
    val latitude: Double,
    val longitude: Double
)

interface Locatable {
    fun getLocation(): Location
}

@Composable
expect fun rememberLocatable(): Locatable