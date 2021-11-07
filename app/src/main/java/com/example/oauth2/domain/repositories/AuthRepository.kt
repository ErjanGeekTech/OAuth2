package com.example.oauth2.domain.repositories

import com.example.newsapp.common.resource.Resource
import com.example.oauth2.data.dtos.models.AuthTokenDto
import com.example.oauth2.domain.models.AuthToken
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun createUser(username: String, pass: String): Flow<Resource<AuthToken>>
}