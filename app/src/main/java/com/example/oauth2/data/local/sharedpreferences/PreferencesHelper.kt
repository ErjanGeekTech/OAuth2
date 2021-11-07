package com.example.oauth2.data.local.sharedpreferences

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper @Inject constructor(private val preferences: SharedPreferences) {
    var refreshToken: String?
        get() = preferences.getString("refreshToken", "")
        set(value) = preferences.edit().putString("refreshToken", value).apply()

    var expiresIn: Int
        get() = preferences.getInt("expiresIn", 0)
        set(value) = preferences.edit().putInt("expiresIn", value).apply()

}