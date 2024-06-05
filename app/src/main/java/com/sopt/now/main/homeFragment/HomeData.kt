package com.sopt.now.main.homeFragment

import androidx.annotation.DrawableRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

