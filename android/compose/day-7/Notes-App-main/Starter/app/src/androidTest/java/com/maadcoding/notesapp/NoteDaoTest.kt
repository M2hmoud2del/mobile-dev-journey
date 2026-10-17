package com.maadcoding.notesapp

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.database.RoomDBHelper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.collections.first

@RunWith(AndroidJUnit4::class)
class NoteDaoTest {
    private lateinit var db: RoomDBHelper

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder<RoomDBHelper>(
            context = context
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertNote_savesNoteToDatabase() = runTest {
        val note = Note(1, "test1")
        db.dao.upsertNote(note)

        val noteDB = db.dao.getNotes().first()

        assertEquals(note.id, noteDB.first().id)
        assertEquals(note.content, noteDB.first().content)
    }

    @Test
    fun updateNote_updatesNoteToDatabase() = runTest {
        val note = Note(1, "test1")
        db.dao.upsertNote(note)

        note.content = "test2"
        db.dao.upsertNote(note)

        val noteDB = db.dao.getNotes().first()

        assertEquals(note.id, noteDB.first().id)
        assertEquals(note.content, noteDB.first().content)
    }

    @Test
    fun deleteNote_deleteNoteFromDatabase() = runTest {
        val note = Note(1,"test1")
        db.dao.upsertNote(note)

        db.dao.deleteNote(note)

        val noteDB = db.dao.getNotes().first()

        assertFalse(
            noteDB.any {
                it.id == note.id && it.content == note.content
            }
        )
    }

    @Test
    fun getNotes_getNotesFromDatabase() = runTest {
        val note1 = Note(1, "test1")
        val note2 = Note(2, "test2")

        db.dao.upsertNote(note1)
        db.dao.upsertNote(note2)

        val notesDB = db.dao.getNotes().first()

        assertEquals(2, notesDB.size)

        assertTrue(notesDB.any {
            it.id == note1.id && it.content == note1.content
        })

        assertTrue(notesDB.any {
            it.id == note2.id && it.content == note2.content
        })
    }
}