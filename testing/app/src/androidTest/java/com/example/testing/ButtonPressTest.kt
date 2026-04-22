package com.example.testing

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class ButtonPressTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun checkButtonPress() {
        rule.setContent { App(); }

        rule.onNodeWithText("Show text")
            .performClick()

        // Wait until compose is done changing screen
        rule.waitForIdle()

        rule.onNodeWithText("Show this text")
            .assertExists()
    }
}