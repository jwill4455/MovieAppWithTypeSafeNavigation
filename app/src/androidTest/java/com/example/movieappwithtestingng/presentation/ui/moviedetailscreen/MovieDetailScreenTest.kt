package com.example.movieappwithtestingng.presentation.ui.moviedetailscreen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.movieappwithtestingng.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MovieDetailScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testMovieDetailDisplayed() {
        composeTestRule.onNodeWithText("The Shawshank Redemption").performClick()

        composeTestRule.onNodeWithText("The Shawshank Redemption").assertExists()
        composeTestRule.onNodeWithText("Release Date: 1994-09-23").assertExists()
    }
}
