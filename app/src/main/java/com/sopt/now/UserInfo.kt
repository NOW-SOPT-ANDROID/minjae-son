package com.sopt.now

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo (
    val authenticationId: String,
    val nickname: String,
    val phone: String
)