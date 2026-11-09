package com.gedo0x.weatherapp

import androidx.compose.runtime.Composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("lat")
    val latitude: Double,
    @SerialName("lon")
    val longitude: Double
)

interface Locatable {
    suspend fun getLocation(): Location
}

@Composable
expect fun rememberLocatable(): Locatable