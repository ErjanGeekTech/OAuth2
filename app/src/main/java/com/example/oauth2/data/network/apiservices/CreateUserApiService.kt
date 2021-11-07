package com.example.oauth2.data.network.apiservices

import com.example.oauth2.data.dtos.models.AuthTokenDto
import com.example.oauth2.data.dtos.models.AuthorizeModelDto
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface CreateUserApiService {

    @POST("token")
    @FormUrlEncoded
    suspend fun createUser(
        @Field("grant_type") grantType: String,
        @Field("code") code: String,
        @Field("redirect_uri") redirect_uri: String
    ): AuthTokenDto

    @GET("/authorize")
    suspend fun fetchAuthorize(): AuthorizeModelDto

    @FormUrlEncoded
    @POST("oauth/token")
    fun refreshAuthToken(
        @Field("grant_type") grantType: String,
        @Field("refresh_token") refreshToken: String,
        @Field("expiresIn") expiresIn: Int
    ): Response<AuthTokenDto>

}
