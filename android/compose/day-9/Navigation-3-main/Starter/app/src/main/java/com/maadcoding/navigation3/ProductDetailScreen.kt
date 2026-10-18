package com.maadcoding.navigation3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maadcoding.navigation3.ui.theme.LightOrange

@Composable
fun ProductDetailScreen(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightOrange)
            .padding(16.dp)
    ) {
        Text(
            text = "Product Details",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "Product Name: ${product.name}")
        Text(text = "Product ID: ${product.id}")
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(Product("1", "Phone"))
}