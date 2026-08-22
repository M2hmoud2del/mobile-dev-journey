package com.maadcoding.bedtimestories

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "settings")

object UserPreferences {
    val TEXT_SIZE_KEY = intPreferencesKey("size")
}