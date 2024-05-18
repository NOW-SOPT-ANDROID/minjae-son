package com.sopt.now.service

import com.sopt.now.main.homeFragment.ResponseFriendsInfoDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendService {
    @GET("/api/users")
    fun getFriendsInfo(
        @Query("page") page: Int,
    ): Call<ResponseFriendsInfoDto>
}