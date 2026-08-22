package com.maadcoding.bedtimestories

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

class Story(
    @StringRes val title: Int,
    @StringRes val story: Int,
    @DrawableRes val picture: Int,
    @RawRes val sound: Int,
)