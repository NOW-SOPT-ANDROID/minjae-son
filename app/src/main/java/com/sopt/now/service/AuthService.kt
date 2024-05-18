package com.sopt.now.service

import com.sopt.now.main.ResponseUserInfoDto
import com.sopt.now.signIn.RequestSignInDto
import com.sopt.now.signUp.RequestSignUpDto
import com.sopt.now.signIn.ResponseSignInDto
import com.sopt.now.signUp.ResponseSignUpDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    @POST("member/login")
    fun signIn(
        @Body request: RequestSignInDto,
    ): Call<ResponseSignInDto>
}