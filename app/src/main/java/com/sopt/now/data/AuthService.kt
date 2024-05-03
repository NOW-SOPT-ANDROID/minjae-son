package com.sopt.now.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("member/join")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignInDto>

    @POST("member/login")
    fun signIn(
        @Body request: RequestSignInDto,
    ): Call<ResponseSignInDto>
}