package com.sopt.now.ui.main.home

import androidx.annotation.DrawableRes

class HomeData {
    data class UserProfile(
        @DrawableRes var profileImg: Int?,
        var name: String?,
        var phoneNumber: String?,
        var authenticationId: String?,
    )

    data class FriendProfile(
        var profileImg: String,
        var name: String,
        var authenticationId: String
    )
}

