package com.android.boilerplate.ui.screens.breedlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.boilerplate.domain.dto.Breed
import com.android.boilerplate.ui.common.ScreenContainer
import com.android.boilerplate.ui.theme.BorderGray
import com.android.boilerplate.ui.theme.CardColor
import org.koin.compose.koinInject

@Composable
fun BreedListScreen(
    navController: NavHostController,
) {
    val breedListViewModel = koinInject<BreedListViewModel>()
    val state = breedListViewModel.stateFlow.collectAsState()
    ScreenContainer(navController = navController, title = "Breed List") {

    }
}

@Composable
fun BreedCard(breed: Breed, onCardClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = CardColor,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        border = BorderStroke(1.dp, color = BorderGray),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(end = 12.dp)
            ) {
                Text(
                    text = breed.attributes.name,
                    modifier = Modifier.padding(bottom = 6.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            IconButton(onClick = onCardClick) {

            }
        }
    }
}



