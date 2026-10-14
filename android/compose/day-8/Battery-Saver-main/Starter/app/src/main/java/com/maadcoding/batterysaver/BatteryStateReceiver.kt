package com.maadcoding.batterysaver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryStateReceiver(private val onBatteryLowDetected: (Boolean) -> Unit) :
    BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            Intent.ACTION_BATTERY_LOW -> onBatteryLowDetected(true)
            Intent.ACTION_BATTERY_OKAY -> onBatteryLowDetected(false)
        }
    }
}