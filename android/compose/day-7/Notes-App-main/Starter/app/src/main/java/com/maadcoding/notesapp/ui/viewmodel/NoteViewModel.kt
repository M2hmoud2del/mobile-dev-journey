package com.maadcoding.notesapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.database.RoomDBHelper
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : AndroidViewModel(app) {
    private val db = RoomDBHelper.getInstance(app)

    fun upsert(n: Note) {
        viewModelScope.launch {
            db.dao.upsertNote(n)
        }
    }

    fun delete(n: Note) {
        viewModelScope.launch {
            db.dao.deleteNote(n)
        }
    }

    fun getNotes() = db.dao.getNotes()
}