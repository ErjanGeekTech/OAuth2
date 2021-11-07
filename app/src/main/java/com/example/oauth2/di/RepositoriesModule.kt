package com.example.oauth2.di

import com.example.oauth2.data.network.apiservices.CreateUserApiService
import com.example.oauth2.data.repositories.AuthRepositoryImpl
import com.example.oauth2.data.repositories.AuthorizeRepositoryImpl
import com.example.oauth2.domain.repositories.AuthRepository
import com.example.oauth2.domain.repositories.AuthorizeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideAuthRepository(service: CreateUserApiService): AuthRepository =
        AuthRepositoryImpl(service)

    @Provides
    fun provideAuthorizeRepository(service: CreateUserApiService): AuthorizeRepository =
        AuthorizeRepositoryImpl(service)
}