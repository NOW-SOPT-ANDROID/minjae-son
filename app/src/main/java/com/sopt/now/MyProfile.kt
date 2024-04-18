package com.sopt.now

import androidx.annotation.DrawableRes

data class MyProfile(
    @DrawableRes val profileImage: Int,
    val name: String,
    val place: String,
    val selfDescription: String,
    val enable: Boolean,
)