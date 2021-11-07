package com.example.oauth2.data.repositories

import com.example.oauth2.base.BaseRepository
import com.example.oauth2.data.dtos.toAuth
import com.example.oauth2.data.network.apiservices.CreateUserApiService
import com.example.oauth2.domain.models.AuthToken
import javax.inject.Inject

class RefreshTokenRepositoryImpl @Inject constructor(private val service: CreateUserApiService) :
    BaseRepository() {

    fun updateRefreshToken(
        grant_type: String,
        refreshToken: String,
        expiresIn: Int
    ): AuthToken? =
        service.refreshAuthToken(grant_type, refreshToken, expiresIn).body()?.toAuth()

}