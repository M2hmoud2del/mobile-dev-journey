package com.gedo0x.weatherapp.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

suspend fun getWeather(latitude: Double, longitude: Double): Double {
    val client = HttpClient(CIO){
        install(ContentNegotiation) {
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
    }
    val response: Temperature = client
        .get("https://api.weatherapi.com/v1/current.json?key=19176843b6504ee7ab282754260711&q=$latitude,$longitude")
        .body()
    client.close()

    return response.current.temperature
}