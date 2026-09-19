package com.excercise.cookit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shimmer()
            .background(Color.LightGray)
    )
}