package com.android.boilerplate.ui.screens.breedlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.android.boilerplate.config.Screen
import com.android.boilerplate.config.createRoute
import com.android.boilerplate.domain.dto.Breed
import com.android.boilerplate.domain.models.BreedList
import com.android.boilerplate.ui.common.AppLoader
import com.android.boilerplate.ui.common.ErrorPage
import com.android.boilerplate.ui.common.ScreenContainer
import com.android.boilerplate.ui.theme.BorderGray
import org.koin.compose.koinInject

@Composable
fun BreedListScreen(
    navController: NavHostController,
) {
    val breedListViewModel = koinInject<BreedListViewModel>()
    val state by breedListViewModel.stateFlow.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        breedListViewModel.getListOfBreeds()
    }
    ScreenContainer(navController = navController, title = "Breed List") {
        when (state) {
            is BreedListState.Loading -> AppLoader()
            is BreedListState.BreedsLoaded -> BreedList((state as BreedListState.BreedsLoaded).breedList) {
                navController.navigate(Screen.BreedDetail.createRoute(params = it))
            }

            is BreedListState.Error -> ErrorPage(retry = {
                breedListViewModel.getListOfBreeds()
            }, errorMessage = (state as BreedListState.Error).message)
        }
    }
}

@Composable
fun BreedList(breedList: BreedList, onCardClick: (id: String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp),
    ) {
        items(breedList.list) {
            BreedCard(breed = it, onCardClick = onCardClick)
        }
    }
}

@Composable
fun BreedCard(breed: Breed, onCardClick: (id: String) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(),
        border = BorderStroke(1.dp, color = BorderGray),
        onClick = {
            onCardClick(breed.id)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = breed.attributes.name,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                modifier = Modifier
                    .size(48.dp)
                    .padding(12.dp),
                contentDescription = "right arrow"
            )

        }
    }
}



