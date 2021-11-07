package com.example.oauth2.data.network.authenticator

import android.util.Log
import com.example.oauth2.data.dtos.toAuth
import com.example.oauth2.data.local.sharedpreferences.PreferencesHelper
import com.example.oauth2.data.network.apiservices.CreateUserApiService
import com.example.oauth2.domain.models.AuthToken
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenRefreshAuthenticator : Authenticator {

    @Inject
    lateinit var preferences: PreferencesHelper

    @Inject
    lateinit var service: CreateUserApiService

    override fun authenticate(route: Route?, response: Response): Request? = when {
        response.retryCount > 2 -> null
        else -> response.createSignedRequest()
    }

    private fun Response.createSignedRequest(): Request? = try {
        val accessToken = service.refreshAuthToken(
            "refresh_token",
            preferences.refreshToken.toString(),
            preferences.expiresIn
        )
        request.signWithToken(accessToken.body()?.toAuth())
    } catch (error: Throwable) {
        Log.e("anime", "$error Failed to re-sign request")
        null
    }
}

private val Response.retryCount: Int
    get() {
        var currentResponse = priorResponse
        var result = 0
        while (currentResponse != null) {
            result++
            currentResponse = currentResponse.priorResponse
        }
        return result
    }

fun Request.signWithToken(accessToken: AuthToken?) =
    newBuilder()
        .header("Authorization", "Bearer ${accessToken?.accessToken}")
        .build()