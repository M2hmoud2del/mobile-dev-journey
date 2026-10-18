package com.maadcoding.navigation3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object ProductList : NavKey

@Serializable
class ProductDetail(val product: Product) : NavKey