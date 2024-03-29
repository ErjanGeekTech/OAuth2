package com.example.oauth2.data.repositories

import com.example.newsapp.common.resource.Resource
import com.example.oauth2.base.BaseRepository
import com.example.oauth2.data.dtos.toAuthorize
import com.example.oauth2.data.network.apiservices.CreateUserApiService
import com.example.oauth2.domain.models.AuthorizeModel
import com.example.oauth2.domain.repositories.AuthorizeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AuthorizeRepositoryImpl @Inject constructor(private val service: CreateUserApiService) :
    BaseRepository(), AuthorizeRepository {

    override fun fetchAuthorize(): Flow<Resource<AuthorizeModel>> {
        return doRequest { service.fetchAuthorize().toAuthorize() }
    }
}