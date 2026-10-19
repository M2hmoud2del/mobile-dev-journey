package com.maadcoding.notesapp.ui.activity

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.ui.theme.NotesAppTheme
import com.maadcoding.notesapp.ui.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(
    note: Note,
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = viewModel(),
    onNavigateBack: () -> Unit = {}
) {
    val context = LocalContext.current

    EditNoteContent(
        note = note,
        modifier = modifier,
        onUpdate = { content ->
            val n = Note(note.id, content)
            viewModel.upsert(n)
            Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show()
            onNavigateBack()
        },
        onDelete = {
            viewModel.delete(note)
            Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
            onNavigateBack()
        }
    )
}

@Composable
fun EditNoteContent(
    note: Note,
    modifier: Modifier = Modifier,
    onUpdate: (String) -> Unit = {},
    onDelete: () -> Unit = {}
) {
    val noteFieldState = rememberTextFieldState(note.content)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        OutlinedTextField(
            state = noteFieldState,
            label = { Text("Note details") },
            modifier = Modifier
                .padding(top = 64.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            OutlinedButton(
                onClick = {
                    onUpdate(noteFieldState.text.toString())
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Update")
            }
            OutlinedButton(
                onClick = onDelete,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = "Delete")
            }
        }
    }
}

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun EditNoteScreenContentPreview() {
    NotesAppTheme {
        EditNoteContent(Note(0, "Sample note"))
    }
}
