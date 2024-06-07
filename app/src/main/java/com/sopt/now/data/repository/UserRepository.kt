package com.sopt.now.data.repository

import com.sopt.now.data.request.RequestSignInDto
import com.sopt.now.data.request.RequestSignUpDto
import com.sopt.now.data.response.ResponseSignInDto
import com.sopt.now.data.response.ResponseSignUpDto
import com.sopt.now.data.response.ResponseUserInfoDto
import com.sopt.now.data.service.AuthService
import com.sopt.now.data.service.UserService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject
constructor(
    private val userService: UserService,
) {
    suspend fun getUserInfo(memberId:Int): Response<ResponseUserInfoDto> {
        return userService.getUserInfo(memberId)
    }
}