package com.sopt.now.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.now.BuildConfig
import com.sopt.now.data.service.AuthService
import com.sopt.now.data.service.FriendService
import com.sopt.now.data.service.UserService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object ApiFactory {
    lateinit var retrofit: Retrofit

    @Synchronized
    fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOkHttpClient())
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            },
        )
    }

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(getLoggingInterceptor())
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val authService: AuthService by lazy { ApiFactory.create() }
    val friendService: FriendService by lazy { ApiFactory.create() }
    val userService: UserService by lazy { ApiFactory.create() }
}