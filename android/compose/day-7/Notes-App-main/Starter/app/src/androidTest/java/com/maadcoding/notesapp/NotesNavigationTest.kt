package com.maadcoding.notesapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.maadcoding.notesapp.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToAddNote_and_saveNote_displaysNoteInList() {
        // Click FAB to navigate to AddNoteScreen
        composeTestRule.onNodeWithContentDescription("Add note page button").performClick()

        // Verify AddNoteScreen is displayed
        composeTestRule.onNodeWithText("Note details").assertIsDisplayed()
        composeTestRule.onNodeWithText("Save").assertIsDisplayed()

        // Enter note content and save
        composeTestRule.onNodeWithText("Note details").performTextInput("Test Navigation Note")
        composeTestRule.onNodeWithText("Save").performClick()

        // Verify return to HomeScreen and note is displayed
        composeTestRule.onNodeWithText("Test Navigation Note").assertIsDisplayed()
    }
}
