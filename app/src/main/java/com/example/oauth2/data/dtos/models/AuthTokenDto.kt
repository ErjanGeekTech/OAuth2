package com.example.oauth2.data.dtos.models

import com.google.gson.annotations.SerializedName

data class AuthTokenDto(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("create_at")
    val createAt: Int,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("scope")
    val scope: String,

    @SerializedName("token_type")
    val tokenType: String
)