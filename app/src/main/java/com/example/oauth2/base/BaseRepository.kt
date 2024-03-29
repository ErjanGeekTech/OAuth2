package com.example.oauth2.base

import com.example.newsapp.common.resource.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (e: Exception) {
            emit(
                Resource.Error(
                    data = null, message = e.localizedMessage ?: "Error Occurred"
                )
            )
        }
    }
}