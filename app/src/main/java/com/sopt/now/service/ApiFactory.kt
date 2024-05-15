package com.sopt.now.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.now.BuildConfig
import com.sopt.now.BuildConfig.AUTH_BASE_URL
import com.sopt.now.BuildConfig.FRIEND_BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


object ApiFactory {
    private const val AUTH_BASE_URL: String = BuildConfig.AUTH_BASE_URL
    private const val FRIEND_BASE_URL: String = BuildConfig.FRIEND_BASE_URL
    fun provideRetrofit(url:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    inline fun <reified T> create(url: String): T = provideRetrofit(url).create(T::class.java)
}

object ServicePool {
    val authService = ApiFactory.create<AuthService>(AUTH_BASE_URL)
    val userService = ApiFactory.create<UserService>(AUTH_BASE_URL)
    val friendService = ApiFactory.create<FriendService>(FRIEND_BASE_URL)
}