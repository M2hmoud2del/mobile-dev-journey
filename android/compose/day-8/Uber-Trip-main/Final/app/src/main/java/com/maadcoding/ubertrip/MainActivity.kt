package com.maadcoding.ubertrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.maadcoding.ubertrip.ui.theme.UberTripTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UberTripTheme {
                AppNavHost()
            }
        }
    }
}


