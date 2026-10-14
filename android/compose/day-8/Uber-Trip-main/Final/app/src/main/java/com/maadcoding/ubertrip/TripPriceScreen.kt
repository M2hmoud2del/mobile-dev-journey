package com.maadcoding.ubertrip

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TripPriceScreen(
    navigator: Navigator,
    km: Float,
    time: Int,
    traffic: Float,
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    val message = stringResource(R.string.price_calculated_successfully)
    val actionLabel = stringResource(R.string.start_over)
    //Scaffold implements the basic visual layout structure (fab - top bar - bottom bar)
    Scaffold(
        //Component to host Snackbars
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { contentPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(contentPadding)

        ) {
            var price by remember { mutableIntStateOf(0) }
            val priceCounter by animateIntAsState(
                targetValue = price,
                animationSpec = tween(
                    durationMillis = 4000,
                    easing = FastOutSlowInEasing
                ), label = "result_animation"
            )
            LaunchedEffect(Unit) {
                price = calculatePrice(km, time, traffic)
                snackbarHostState.showSnackbar(
                    message = message,
                    duration = SnackbarDuration.Long
                )
            }
            Text(text = stringResource(R.string.estimated_trip_price_is))
            Text(
                text = priceCounter.toString(),
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = stringResource(R.string.egp))
        }
    }
}

fun calculatePrice(km: Float, time: Int, traffic: Float): Int {
    if (km < 1)
        return 60

    val baseFare = 8
    val kmPrice = km * 7.5
    var total = baseFare + kmPrice + time
    total += (total * traffic)
    return total.toInt()
}