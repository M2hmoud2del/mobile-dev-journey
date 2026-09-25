package com.example.fitnesscounter

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel: ViewModel() {
    val liveCounter: StateFlow<Int>
        field = MutableStateFlow(0)

    fun incrementCounter() {
        liveCounter.update { it + 1 }
    }
}