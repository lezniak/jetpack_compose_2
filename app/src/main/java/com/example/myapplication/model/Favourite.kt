package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Favourite(
    @StringRes val name : Int,
    @DrawableRes val icon : Int
)