package com.sopt.now.data.service

import com.sopt.now.data.response.ResponseFriendsInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendService {
    @GET("/api/users")
    suspend fun getFriendsInfo(
        @Query("page") page: Int,
    ): Response<ResponseFriendsInfoDto>
}