package com.sopt.now.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignInDto(
    @SerialName("code")
    val status: Int,
    @SerialName("message")
    val message: String,
)