package com.maadcoding.navigation3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maadcoding.navigation3.ui.theme.LightBlue

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit
) {
    val products = listOf(
        Product("1", "Laptop"),
        Product("2", "Phone"),
        Product("3", "Headphones")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
    ) {
        items(products) { product ->
            Text(
                text = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onProductClick(product)
                    }
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen {}
}