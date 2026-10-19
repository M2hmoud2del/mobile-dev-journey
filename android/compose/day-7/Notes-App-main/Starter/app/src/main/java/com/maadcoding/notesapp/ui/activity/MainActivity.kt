package com.maadcoding.notesapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.navigation.AddNoteScreenKey
import com.maadcoding.notesapp.navigation.EditNoteScreenKey
import com.maadcoding.notesapp.navigation.HomeScreenKey
import com.maadcoding.notesapp.ui.icon.add
import com.maadcoding.notesapp.ui.theme.NotesAppTheme
import com.maadcoding.notesapp.ui.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesNavApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NotesNavApp(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(HomeScreenKey)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<HomeScreenKey> {
                HomeScreen(
                    onAddNoteClick = {
                        backStack.add(AddNoteScreenKey)
                    },
                    onNoteClick = { note ->
                        backStack.add(EditNoteScreenKey(note))
                    }
                )
            }
            entry<AddNoteScreenKey> {
                AddNoteScreen(
                    onNavigateBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
            entry<EditNoteScreenKey> { key ->
                EditNoteScreen(
                    note = key.note,
                    onNavigateBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            )
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            )
        },
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = viewModel(),
    onAddNoteClick: () -> Unit = {},
    onNoteClick: (Note) -> Unit = {}
) {
    val notes by viewModel.getNotes().collectAsState(emptyList())
    HomeScreenContent(
        notes = notes,
        modifier = modifier,
        onAddNoteClick = onAddNoteClick,
        onNoteClick = onNoteClick
    )
}

@Composable
fun HomeScreenContent(
    notes: List<Note>,
    modifier: Modifier = Modifier,
    onAddNoteClick: () -> Unit = {},
    onNoteClick: (Note) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClick,
                containerColor = Color.Blue,
            ) {
                Icon(
                    imageVector = add,
                    contentDescription = "Add note page button",
                    tint = Color.White,
                )
            }
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(notes) { note ->
                NoteListItem(note) {
                    onNoteClick(note)
                }
            }
        }
    }
}

@Composable
fun NoteListItem(note: Note, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = note.content,
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(8.dp)
                .defaultMinSize(minHeight = 80.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }
}

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun HomeScreenPreview() {
    NotesAppTheme {
        HomeScreenContent(
            notes = listOf(
                Note(id = 1, content = "Sample Note 1"),
                Note(id = 2, content = "Sample Note 2")
            )
        )
    }
}

@Preview
@Composable
private fun NoteListItemPreview() {
    NoteListItem(Note(5, "")) {}
}
