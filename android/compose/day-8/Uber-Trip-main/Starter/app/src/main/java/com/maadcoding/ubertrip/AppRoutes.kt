package com.maadcoding.ubertrip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

@Serializable
data object StartRoute : NavKey

@Serializable
data object DistanceRoute : NavKey

@Serializable
data class TimeRoute(val km: Float) : NavKey

@Serializable
data class TrafficOptionsRoute(val km: Float, val time: Int) : NavKey

@Serializable
data class TripPriceRoute(val km: Float, val time: Int, val traffic: Float) : NavKey

@Composable
fun AppNavHost() {
    val navigationState = rememberNavigationState(
        startRoute = StartRoute,
        topLevelRoutes = setOf(StartRoute)
    )

    val navigator = remember { Navigator(navigationState) }

    val entryProvider = entryProvider {
        entry<StartRoute> { StartScreen(navigator) }
        entry<DistanceRoute> { DistanceScreen(navigator) }
        entry<TimeRoute> { key ->
            TimeScreen(navigator, key.km)
        }
        entry<TrafficOptionsRoute> { key ->
            TrafficOptionsScreen(navigator, km = key.km, time = key.time)
        }
        entry<TripPriceRoute> { key ->
            TripPriceScreen(navigator, km = key.km, time = key.time, traffic = key.traffic)
        }
    }

    NavDisplay(
        entries = navigationState.toEntries(entryProvider),
        onBack = { navigator.goBack() }
    )
}
