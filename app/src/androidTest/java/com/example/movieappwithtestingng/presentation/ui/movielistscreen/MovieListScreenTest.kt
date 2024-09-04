package com.example.movieappwithtestingng.presentation.ui.movielistscreen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.movieappwithtestingng.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MovieListScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testMovieListIsDisplayed() {
        composeTestRule.onNodeWithText("Search Movies...").assertExists()

        composeTestRule.onNodeWithText("The Shawshank Redemption").assertExists()
    }

    @Test
    fun testMovieSearchBarTyping() {
        val searchText = "Shawshank"

        composeTestRule.onNodeWithContentDescription("Movie Search Bar...")
            .performClick()

        composeTestRule.onNodeWithContentDescription("Movie Search Bar...")
            .performTextInput(searchText)

        composeTestRule.onNodeWithText("The Shawshank Redemption").assertExists()
    }
}
