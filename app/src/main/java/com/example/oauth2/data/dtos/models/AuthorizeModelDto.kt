package com.example.oauth2.data.dtos.models

import com.google.gson.annotations.SerializedName

data class AuthorizeModelDto(
    @SerializedName("client_id")
    val client_id: String = "",

    @SerializedName("response_type")
    val response_type: String = "",

    @SerializedName("redirect_uri")
    val redirect_uri: String = ""
)