package com.example.oauth2.data.dtos

import com.example.oauth2.data.dtos.models.AuthTokenDto
import com.example.oauth2.data.dtos.models.AuthorizeModelDto
import com.example.oauth2.domain.models.AuthToken
import com.example.oauth2.domain.models.AuthorizeModel

fun AuthTokenDto.toAuth() =
    AuthToken(accessToken, createAt, expiresIn, refreshToken, scope, tokenType)

fun AuthorizeModelDto.toAuthorize() = AuthorizeModel(redirect_uri)