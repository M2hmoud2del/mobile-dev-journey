package com.maadcoding.bedtimestories

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

class Story (
    @StringRes val title : Int,
    @StringRes val details : Int,
    @DrawableRes val pic : Int,
    @RawRes val sound : Int,
)