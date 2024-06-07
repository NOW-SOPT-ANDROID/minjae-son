package com.sopt.now.data.repository

import com.sopt.now.data.request.RequestSignInDto
import com.sopt.now.data.request.RequestSignUpDto
import com.sopt.now.data.response.ResponseSignInDto
import com.sopt.now.data.response.ResponseSignUpDto
import com.sopt.now.data.service.AuthService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository
@Inject
constructor(
    private val authService: AuthService,
) {
    suspend fun signUp(request: RequestSignUpDto): Response<ResponseSignUpDto> {
        return authService.signUp(request)
    }

    suspend fun signIn(request: RequestSignInDto): Response<ResponseSignInDto> {
        return authService.signIn(request)
    }
}
