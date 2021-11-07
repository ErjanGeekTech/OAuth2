package com.example.oauth2.domain.models

data class AuthorizeModel(
    val client_id: String = "",
    val response_type: String = "",
    val redirect_uri: String = ""
)