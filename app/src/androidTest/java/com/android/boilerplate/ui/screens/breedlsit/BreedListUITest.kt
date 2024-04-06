package com.android.boilerplate.ui.screens.breedlsit

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import com.android.boilerplate.domain.dto.Breed
import com.android.boilerplate.domain.dto.BreedAttributes
import com.android.boilerplate.ui.screens.breedlist.BreedCard
import org.junit.Rule
import org.junit.Test


class BreedListUITest {
    @get:Rule
    val rule = createComposeRule()
    val testBreed = Breed("1", "Domestic", BreedAttributes("German Shephard", "Friendly", false))

    @Test
    fun testBreedCard() {
        rule.setContent {
            BreedCard(breed = testBreed) {
            }
        }
        rule.onNodeWithText("German Shephard").assertExists()
    }
}