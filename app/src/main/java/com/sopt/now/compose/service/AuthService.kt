package com.sopt.now.compose.service

import com.sopt.now.compose.request.RequestSignInDto
import com.sopt.now.compose.request.RequestSignUpDto
import com.sopt.now.compose.response.ResponseSignInDto
import com.sopt.now.compose.response.ResponseSignUpDto
import com.sopt.now.compose.response.ResponseUserInfoDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    fun signUp(
        @Body request: RequestSignUpDto
    ): Call<ResponseSignUpDto>

    @POST("member/login")
    fun signIn(
        @Body request : RequestSignInDto
    ) : Call<ResponseSignInDto>
}