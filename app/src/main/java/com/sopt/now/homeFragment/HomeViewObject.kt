package com.sopt.now.homeFragment

import androidx.annotation.DrawableRes

sealed class HomeViewObject {
    data class MyProfile(
        @DrawableRes val profileImage: Int,
        val name: String,
        val phoneNumber: String,
        val selfDescription: String,
        val enable: Boolean,
    ) : HomeViewObject()

    data class FriendProfile(
        @DrawableRes val profileImage: Int,
        val name: String,
        val phoneNumber: String,
        val selfDescription: String,
    ) : HomeViewObject()
}