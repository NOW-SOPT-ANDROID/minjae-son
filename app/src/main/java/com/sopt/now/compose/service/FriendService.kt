package com.sopt.now.compose.service

import com.sopt.now.compose.response.ResponseFriendsInfoDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendService {
    @GET("/api/users")
    fun getFriendsInfo(
        @Query("page") page: Int,
    ): Call<ResponseFriendsInfoDto>
}