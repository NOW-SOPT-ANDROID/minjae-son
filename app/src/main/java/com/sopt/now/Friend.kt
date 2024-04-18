package com.sopt.now

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes val profileImage: Int,
    val name: String,
    val place: String,
    val selfDescription: String,
)
