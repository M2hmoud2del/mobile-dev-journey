package com.maadcoding.ubertrip

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DistanceScreen(navigator: Navigator, modifier: Modifier = Modifier) {
    DataEntry(
        text = R.string.enter_the_total_distance,
        fieldLabel = R.string.distance_in_kilometers,
        onClick = { distanceField ->
            val distance = distanceField.toFloat()
            navigator.navigate(TimeRoute(distance))
        },
        modifier = modifier
    )
}
