package com.example.mycomposeproject.feature.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Text("Hello")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}