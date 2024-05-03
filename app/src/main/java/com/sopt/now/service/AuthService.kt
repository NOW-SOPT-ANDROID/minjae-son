package com.sopt.now.service

import com.sopt.now.data.RequestSignInDto
import com.sopt.now.data.RequestSignUpDto
import com.sopt.now.data.ResponseSignInDto
import com.sopt.now.data.ResponseSignUpDto
import com.sopt.now.data.ResponseUserInfoDto
import retrofit2.Call
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

    @GET("member/info")
    fun getUserInfo(
        @Header("memberId") memberId: Int,
    ): Call<ResponseUserInfoDto>
}