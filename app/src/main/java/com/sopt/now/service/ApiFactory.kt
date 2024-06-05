package com.sopt.now.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.now.BuildConfig
import com.sopt.now.BuildConfig.AUTH_BASE_URL
import com.sopt.now.BuildConfig.FRIEND_BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object ApiFactory {
    private const val AUTH_BASE_URL: String = BuildConfig.AUTH_BASE_URL
    private const val FRIEND_BASE_URL: String = BuildConfig.FRIEND_BASE_URL

    // HTTP 로깅 인터셉터 설정
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttpClient 설정
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)  // 로깅 인터셉터 추가
        .connectTimeout(30, TimeUnit.SECONDS) // 연결 타임아웃
        .readTimeout(30, TimeUnit.SECONDS)    // 읽기 타임아웃
        .writeTimeout(30, TimeUnit.SECONDS)   // 쓰기 타임아웃
        .build()

    fun provideRetrofit(url:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
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