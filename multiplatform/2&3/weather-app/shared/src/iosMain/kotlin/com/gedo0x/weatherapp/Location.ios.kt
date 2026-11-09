package com.gedo0x.weatherapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.GeolocatorResult
import dev.jordond.compass.geolocation.mobile


class IOSLocatable: Locatable {
    override suspend fun getLocation(): Location {
        val geolocator: Geolocator = Geolocator.mobile()
        val result: GeolocatorResult = geolocator.current()

        return when (result) {
            is GeolocatorResult.Success -> {
                Location(result.data.coordinates.latitude,result.data.coordinates.longitude)
            }
            is GeolocatorResult.Error -> {
                throw Exception("Unable to get current location")
            }
        }
    }
}

@Composable
actual fun rememberLocatable(): Locatable {
    return remember { IOSLocatable() }
}