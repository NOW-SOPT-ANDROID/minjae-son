package com.sopt.now.compose

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("member/join") //http 메소드
    fun signUp(
        @Body request: RequestSignUpDto
    ): Call<ResponseSignUpDto> //비동기->callback

    @POST("member/login")
    fun signIn(
        @Body request : RequestSignInDto
    ) : Call<ResponseSignInDto>

    @GET("/member/info")
    fun getUserInfo(
        @Header("memberId") userId : Int
    ) : Call<ResponseUserInfoDto>
}