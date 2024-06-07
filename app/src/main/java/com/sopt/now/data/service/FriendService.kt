package com.sopt.now.data.service

import com.sopt.now.data.response.ResponseFriendsInfoDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendService {
    @GET("/api/users")
    fun getFriendsInfo(
        @Query("page") page: Int,
    ): Call<ResponseFriendsInfoDto>
}