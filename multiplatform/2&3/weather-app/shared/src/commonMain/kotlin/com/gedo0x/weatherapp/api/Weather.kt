package com.gedo0x.weatherapp.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Temperature {
    val current = Current()
}

@Serializable
class Current {
    @SerialName("temp_c")
    val temperature = 0.0
}