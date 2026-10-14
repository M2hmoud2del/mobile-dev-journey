package com.maadcoding.batterysaver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LifecycleStartEffect
import com.maadcoding.batterysaver.ui.theme.BatterySaverTheme
import com.maadcoding.batterysaver.ui.theme.DustyMint
import com.maadcoding.batterysaver.ui.theme.NeonGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BatterySaverTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var batteryLowDetected by remember { mutableStateOf(false) }
    var isHeavyAnimationEnabled by remember { mutableStateOf(true) }

    val receiver = remember {
        BatteryStateReceiver { batteryState ->
            batteryLowDetected = batteryState
        }
    }
    val context = LocalContext.current

    /*Test Case: Opening the application while the battery is already low,
    the UI won't know until the battery level changes again*/
    val batteryManager =
        context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

    val batteryPercentage =
        batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

    batteryLowDetected = batteryPercentage <= 20

    val filter = remember {
        IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_BATTERY_OKAY)
        }
    }

    LifecycleStartEffect(true) {
        ContextCompat.registerReceiver(
            context,
            receiver,
            filter,
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
        onStopOrDispose { context.unregisterReceiver(receiver) }
    }

    if (batteryLowDetected && isHeavyAnimationEnabled)
        BatteryLowSnackBar {
            isHeavyAnimationEnabled = false
        }

    if (isHeavyAnimationEnabled)
        HeavyAnimation()
}

@Composable
fun HeavyAnimation() {

    val transition = rememberInfiniteTransition(label = "")

    val angle = transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000)
        ),
        label = ""
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        repeat(500) { i ->

            rotate(angle.value + i) {
                drawCircle(
                    brush = Brush.linearGradient(listOf(NeonGreen, DustyMint)),
                    radius = 50f,
                    center = center.copy(
                        x = center.x + i,
                        y = center.y
                    ),
                )
            }
        }
    }
}


@Composable
fun BatteryLowSnackBar(modifier: Modifier = Modifier, onHideAnimation: () -> Unit) {
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
    ) { _ -> }

    LaunchedEffect(Unit) {
        val result = snackBarHostState.showSnackbar(
            message = "Battery is Low",
            actionLabel = "Enable Power Saving Mode",
            duration = SnackbarDuration.Indefinite
        )
        if (result == SnackbarResult.ActionPerformed)
            onHideAnimation()
    }

}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}