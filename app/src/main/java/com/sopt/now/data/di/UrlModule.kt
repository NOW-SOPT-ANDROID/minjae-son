package com.sopt.now.data.di

import com.sopt.now.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object UrlModule {
    @AuthBaseUrl
    @Provides
    fun provideAuthBaseUrl(): String = BuildConfig.AUTH_BASE_URL

    @FriendBaseUrl
    @Provides
    fun provideFriendBaseUrl(): String = BuildConfig.FRIEND_BASE_URL
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class AuthBaseUrl

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class FriendBaseUrl