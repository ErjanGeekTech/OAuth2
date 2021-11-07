package com.example.oauth2.domain.models

data class AuthToken(
    val accessToken: String,
    val createAt: Int,
    val expiresIn: Int,
    val refreshToken: String,
    val scope: String,
    val tokenType: String
)