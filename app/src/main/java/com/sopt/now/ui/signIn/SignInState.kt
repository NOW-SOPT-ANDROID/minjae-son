package com.sopt.now.ui.signIn

data class SignInState(
    val isSuccess: Boolean,
    val message: String,
    val memberId: String? = ""
)