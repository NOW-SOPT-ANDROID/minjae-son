package com.sopt.now.data.service

import com.sopt.now.data.request.RequestSignInDto
import com.sopt.now.data.request.RequestSignUpDto
import com.sopt.now.data.response.ResponseSignInDto
import com.sopt.now.data.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    suspend fun signUp(
        @Body request: RequestSignUpDto,
    ): Response<ResponseSignUpDto>

    @POST("member/login")
    suspend fun signIn(
        @Body request: RequestSignInDto,
    ): Response<ResponseSignInDto>
}