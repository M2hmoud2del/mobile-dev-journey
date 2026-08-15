package com.example.quicklogin

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.datastore by preferencesDataStore("user_data")

object PreferencesKeys {
    val EMAIL_KEY = stringPreferencesKey("email")
    val PASSWORD_KEY = stringPreferencesKey("password")
}