package com.excercise.emergencyapp

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class EmergencyContact(
    @StringRes val name: Int,
    @StringRes val category: Int,
    val phoneNumber: Int,
    @DrawableRes val contactIcon: Int,
    @ColorRes val contactIconColor: Int,
    @ColorRes val iconColor: Int
)