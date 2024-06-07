package com.sopt.now.data.service

import com.sopt.now.data.response.ResponseUserInfoDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("member/info")
    suspend fun getUserInfo(
        @Header("memberId") memberId: Int,
    ): Response<ResponseUserInfoDto>
}