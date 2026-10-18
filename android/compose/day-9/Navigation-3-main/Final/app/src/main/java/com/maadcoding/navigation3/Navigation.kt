package com.maadcoding.navigation3

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun NavApp(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(ProductList)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<ProductList> {
                ProductListScreen { product ->
                    backStack.add(ProductDetail(product))
                }
            }
            entry<ProductDetail> {
                ProductDetailScreen(it.product)
            }
        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith slideOutHorizontally(
                targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInVertically(initialOffsetY = { -it }) + fadeIn() togetherWith
                    slideOutVertically(targetOffsetY = { it }) + fadeOut()
        },
        predictivePopTransitionSpec = {
            slideInVertically(initialOffsetY = { -it }) + fadeIn() togetherWith
                    slideOutVertically(targetOffsetY = { it }) + fadeOut()
        },
        modifier = modifier
    )
}