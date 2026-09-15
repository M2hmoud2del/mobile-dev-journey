package com.excercise.cookit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.excercise.cookit.api.RetrofitInstance
import com.excercise.cookit.data.CategoryModel
import com.excercise.cookit.data.FoodModel
import com.excercise.cookit.ui.CategoryListItem
import com.excercise.cookit.ui.FoodListItem
import com.excercise.cookit.ui.theme.CookItTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookItTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var categories by remember { mutableStateOf<List<CategoryModel>>(emptyList()) }
    var foods by remember { mutableStateOf<List<FoodModel>>(emptyList()) }

    var selectedCategory by remember { mutableStateOf<CategoryModel?>(null) }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.foodAPI.getCategoryData()
            categories = response.categories
        } catch (e: Exception) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(selectedCategory) {
        if (selectedCategory != null) {
            try {
                foods = emptyList()
                val response = RetrofitInstance.foodAPI.getFoodByCategory(selectedCategory!!.name)
                foods = response.foods
            } catch (e: Exception) {
                Toast.makeText(context, "Error fetching foods", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
    ) {

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { categoryItem ->
                CategoryListItem(
                    category = categoryItem,
                ) {
                    selectedCategory = categoryItem
                }
            }
        }

        if (selectedCategory == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Please select a category to show available meals", color = Color.Gray)
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(foods) { foodItem ->
                    FoodListItem(
                        food = foodItem
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    CookItTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}