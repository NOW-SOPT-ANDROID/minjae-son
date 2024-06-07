package com.sopt.now.data.repository

import com.sopt.now.data.response.ResponseFriendsInfoDto
import com.sopt.now.data.service.FriendService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FriendRepository
@Inject
constructor(
    private val friendService: FriendService,
) {
    suspend fun getFriendsInfo(i: Int): Response<ResponseFriendsInfoDto> {
        return friendService.getFriendsInfo(2)
    }
}
