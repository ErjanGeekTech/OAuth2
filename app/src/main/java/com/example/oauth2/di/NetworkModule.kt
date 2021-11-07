package com.example.oauth2.di

import com.example.oauth2.data.network.RetrofitClient
import com.example.oauth2.data.network.apiservices.CreateUserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofit: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun createUser(): CreateUserApiService = retrofit.provideCreateUserApiService()
}