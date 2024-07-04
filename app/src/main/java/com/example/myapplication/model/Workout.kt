package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Workout(
    val id : Int,
    @StringRes val name : Int,
    @DrawableRes val image : Int
)
