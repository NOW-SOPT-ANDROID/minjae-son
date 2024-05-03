package com.sopt.now.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserInfoDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: UserInfo? = defalutUser,
) {
    @Serializable
    data class UserInfo(
        @SerialName("authenticationId")
        val authenticationId: String? = "",
        @SerialName("nickname")
        val nickname: String? = "",
        @SerialName("phone")
        val phone: String? = "",
    )

    companion object {
        val defalutUser = UserInfo()
    }
}



