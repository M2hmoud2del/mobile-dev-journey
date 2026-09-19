package com.excercise.cookit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.excercise.cookit.data.CategoryModel
import com.excercise.cookit.data.FoodModel
import com.excercise.cookit.ui.theme.gradientColors

@Composable
fun FoodListItem(
    food: FoodModel,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable{
                // Some Logic
            },
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .background(
                    color = Color(0xFFEBECEF),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(top = 68.dp, bottom = 20.dp, start = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = food.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }

        SubcomposeAsyncImage(
            model = food.imageURL,
            contentDescription = food.name,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerPlaceholder(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )
            },
            error = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(20.dp)
                        )
                )
            },
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(20.dp))
        )
    }
}

@Composable
fun CategoryListItem(
    category: CategoryModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(80.dp)
            .clickable{
                onClick()
            }
    ) {

        SubcomposeAsyncImage(
            model = category.imageURL,
            contentDescription = category.name,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerPlaceholder(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            },
            error = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color.LightGray,
                            shape = CircleShape
                        )
                )
            },
            modifier = Modifier
                .size(70.dp)
                .border(
                    width = 2.dp,
                    brush = Brush.sweepGradient(colors = gradientColors),
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = category.name,
            fontSize = 13.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun FoodListItemPreview() {
    val food = FoodModel(
        id = "1",
        name = "Æbleskiver",
        imageURL = ""
    )
    FoodListItem(food = food, modifier = Modifier.width(160.dp).padding(16.dp))
}

@Preview(showBackground = true)
@Composable
private fun CategoryListItemPreview() {
    val category = CategoryModel(
        id = "1",
        name = "Dessert",
        imageURL = ""
    )
    CategoryListItem(category = category, modifier = Modifier.padding(16.dp)){}
}