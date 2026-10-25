package com.example.mycomposeproject.feature.home.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeproject.ui.theme.BackgroundLight
import com.example.mycomposeproject.ui.theme.ChipSelectedBackground
import com.example.mycomposeproject.ui.theme.ChipUnselectedBackground
import com.example.mycomposeproject.ui.theme.DarkBlueHero
import com.example.mycomposeproject.ui.theme.PrimaryOrange
import com.example.mycomposeproject.ui.theme.SecondaryBlueHero


// Data Models
data class Category(val id: Int, val name: String, val icon: ImageVector)
data class Product(
    val id: Int,
    val title: String,
    val subtitle: String,
    val originalPrice: String?,
    val currentPrice: String,
    val discount: String?,
    val badge: String?,
    val badgeColor: Color?,
    val rating: Double,
    val reviewsCount: Int,
    val imageUrl: String
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Header Section
            TopHeaderSection()

            Spacer(modifier = Modifier.height(12.dp))

            // Search Bar
            SearchBarSection()

            Spacer(modifier = Modifier.height(16.dp))

            // Banner Card
            PromoBannerSection()

            Spacer(modifier = Modifier.height(20.dp))

            // Categories Section
            CategoriesSection()

            Spacer(modifier = Modifier.height(20.dp))

            // Flash Deals Header
            FlashDealsHeader()

            Spacer(modifier = Modifier.height(12.dp))

            // Product Grid
            ProductGridSection()

            Spacer(modifier = Modifier.height(24.dp))
        }

}

@Composable
fun TopHeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo & Title
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(PrimaryOrange),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = "Logo",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Home",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Notification & Profile
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.Black
                    )
                }
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(PrimaryOrange)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "3",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0F172A)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }
    }

    // Delivery Location Sub-bar
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Deliver to Emily S. \nNew York 10001",
                fontSize = 11.sp,
                color = Color.Gray,
                lineHeight = 13.sp
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Gray
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE0F2FE))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(
                text = "⚡ Prime Fast",
                fontSize = 11.sp,
                color = Color(0xFF0284C7),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun SearchBarSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Search products, brands, essent...",
                color = Color.Gray,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = { },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFE2E8F0))
        ) {
            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Voice Search",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = { },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFE0F2FE))
        ) {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filter",
                tint = Color(0xFF0284C7)
            )
        }
    }
}

@Composable
fun PromoBannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(DarkBlueHero, SecondaryBlueHero)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(PrimaryOrange)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "⚡ MEGA SPRING SALE",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column {
                Text(
                    text = "Up to 50% OFF",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Premium tech, beauty & living...",
                    color = Color.LightGray,
                    fontSize = 11.sp
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text(
                    text = "Shop Now",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Composable
fun CategoriesSection() {
    var selectedCategory by remember { mutableStateOf(0) }

    val categories = listOf(
        Category(0, "All", Icons.Default.GridView),
        Category(1, "Smartphones", Icons.Default.PhoneIphone),
        Category(2, "Laptops", Icons.Default.Laptop),
        Category(3, "Fragrances", Icons.Default.FilterVintage)
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { }
            ) {
                Text(
                    text = "Explore",
                    fontSize = 13.sp,
                    color = PrimaryOrange,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = PrimaryOrange,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                val isSelected = selectedCategory == category.id
                val backgroundColor by animateColorAsState(
                    if (isSelected) ChipSelectedBackground else ChipUnselectedBackground
                )
                val contentColor by animateColorAsState(
                    if (isSelected) Color.White else Color.DarkGray
                )

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(backgroundColor)
                        .clickable { selectedCategory = category.id }
                        .padding(horizontal = 14.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = category.icon,
                        contentDescription = category.name,
                        tint = contentColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = category.name,
                        color = contentColor,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun FlashDealsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "🔥 Flash Deals",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0F2FE))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "⏱️ 02:40:57",
                    fontSize = 11.sp,
                    color = Color(0xFF0284C7),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = "See All",
            fontSize = 13.sp,
            color = PrimaryOrange,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { }
        )
    }
}

@Composable
fun ProductGridSection() {
    val products = listOf(
        Product(
            id = 1,
            title = "iPhone 15 Pro Max",
            subtitle = "256GB Natural Ti",
            originalPrice = "$1,299",
            currentPrice = "$1,199",
            discount = "-8%",
            badge = "Best Seller",
            badgeColor = Color(0xFF1E3A8A),
            rating = 4.9,
            reviewsCount = 128,
            imageUrl = ""
        ),
        Product(
            id = 2,
            title = "MacBook Air M2",
            subtitle = "13.6\" 8-Core Midnight",
            originalPrice = "$1,099",
            currentPrice = "$999",
            discount = "-10%",
            badge = "Top Rated",
            badgeColor = Color(0xFF065F46),
            rating = 4.8,
            reviewsCount = 94,
            imageUrl = ""
        ),
        Product(
            id = 3,
            title = "Chanel Coco EDP",
            subtitle = "Eau De Parfum 100ml",
            originalPrice = null,
            currentPrice = "$135",
            discount = null,
            badge = "Featured",
            badgeColor = Color(0xFF3B82F6),
            rating = 4.7,
            reviewsCount = 210,
            imageUrl = ""
        ),
        Product(
            id = 4,
            title = "Ergo Pro Wireless",
            subtitle = "ANC • 40h Battery",
            originalPrice = "$120",
            currentPrice = "$79",
            discount = "-34%",
            badge = "-34%",
            badgeColor = PrimaryOrange,
            rating = 4.6,
            reviewsCount = 82,
            imageUrl = ""
        )
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProductCard(product = products[0], modifier = Modifier.weight(1f))
            ProductCard(product = products[1], modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProductCard(product = products[2], modifier = Modifier.weight(1f))
            ProductCard(product = products[3], modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Product Image Container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF1F5F9))
            ) {
                // Top Tag Badge
                product.badge?.let { badgeText ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(product.badgeColor ?: PrimaryOrange)
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Text(
                            text = badgeText,
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Heart Icon Button
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Bottom Discount Tag (if any)
                product.discount?.let { discountText ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(PrimaryOrange)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                            .align(Alignment.BottomStart)
                    ) {
                        Text(
                            text = discountText,
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Rating
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFF59E0B),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${product.rating}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "(${product.reviewsCount})",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Title & Subtitle
            Text(
                text = product.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.subtitle,
                fontSize = 10.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Price & Add Button Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    product.originalPrice?.let {
                        Text(
                            text = it,
                            fontSize = 11.sp,
                            color = Color.Gray,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Text(
                        text = product.currentPrice,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(PrimaryOrange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to Cart",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    var selectedTab by remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { selectedTab = 0 },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home", fontSize = 10.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryOrange,
                selectedTextColor = PrimaryOrange,
                indicatorColor = PrimaryOrange.copy(alpha = 0.1f)
            )
        )
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { selectedTab = 1 },
            icon = { Icon(Icons.Default.GridView, contentDescription = "Categories") },
            label = { Text("Categories", fontSize = 10.sp) }
        )
        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { selectedTab = 2 },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search", fontSize = 10.sp) }
        )
        NavigationBarItem(
            selected = selectedTab == 3,
            onClick = { selectedTab = 3 },
            icon = { Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorites") },
            label = { Text("Favorites", fontSize = 10.sp) }
        )
        NavigationBarItem(
            selected = selectedTab == 4,
            onClick = { selectedTab = 4 },
            icon = { Icon(Icons.Default.PersonOutline, contentDescription = "Profile") },
            label = { Text("Profile", fontSize = 10.sp) }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}