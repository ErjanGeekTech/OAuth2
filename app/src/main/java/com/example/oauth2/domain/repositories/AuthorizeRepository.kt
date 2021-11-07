package com.example.oauth2.domain.repositories

import com.example.newsapp.common.resource.Resource
import com.example.oauth2.domain.models.AuthorizeModel
import kotlinx.coroutines.flow.Flow

interface AuthorizeRepository {

    fun fetchAuthorize(): Flow<Resource<AuthorizeModel>>
}