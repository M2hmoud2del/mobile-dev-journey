package com.example.endangeredanimals

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Animal(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val website: String,
    val bg: String = Constants.FOREST_BG
    )