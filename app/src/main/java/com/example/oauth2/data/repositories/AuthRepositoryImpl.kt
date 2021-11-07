package com.example.oauth2.data.repositories

import com.example.oauth2.base.BaseRepository
import com.example.oauth2.data.dtos.toAuth
import com.example.oauth2.data.network.apiservices.CreateUserApiService
import com.example.oauth2.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val service: CreateUserApiService) :
    BaseRepository(), AuthRepository {
    override fun createUser(username: String, pass: String) = doRequest {
        service.createUser("authorization_code", "code", "http://localhost:94.143.197.226/callback")
            .toAuth()
    }

}