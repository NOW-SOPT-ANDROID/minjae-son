package com.sopt.now.signIn

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignInDto(
    @SerialName("code")
    val status: Int,
    @SerialName("message")
    val message: String,
)