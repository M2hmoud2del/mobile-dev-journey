package com.maadcoding.ubertrip

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TimeScreen(navigator: Navigator, km: Float, modifier: Modifier = Modifier) {
    DataEntry(
        text = R.string.enter_the_total_time,
        fieldLabel = R.string.time_in_minutes,
        isTimeInput = true,
        onClick = { timeField ->
            val time = timeField.toInt()
            navigator.navigate(TrafficOptionsRoute(km, time))
        },
        modifier = modifier
    )
}
