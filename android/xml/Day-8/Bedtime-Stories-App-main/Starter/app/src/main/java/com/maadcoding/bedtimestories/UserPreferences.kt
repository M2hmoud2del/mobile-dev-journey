package com.maadcoding.bedtimestories

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.datastore by preferencesDataStore("settings")

object Keys{
    val TEXT_SIZE_KEY = intPreferencesKey("size")

}