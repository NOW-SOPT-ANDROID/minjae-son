package com.sopt.now.signIn

data class SignInState(
    val isSuccess: Boolean,
    val message: String,
    val memberId: String? = ""
)