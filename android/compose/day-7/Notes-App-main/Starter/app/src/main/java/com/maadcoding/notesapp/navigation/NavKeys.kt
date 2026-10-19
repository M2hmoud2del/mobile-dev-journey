package com.maadcoding.notesapp.navigation

import androidx.navigation3.runtime.NavKey
import com.maadcoding.notesapp.database.Note
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreenKey : NavKey

@Serializable
data object AddNoteScreenKey : NavKey

@Serializable
data class EditNoteScreenKey(val note: Note) : NavKey
