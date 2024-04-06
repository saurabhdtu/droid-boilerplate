package com.android.boilerplate.ui.screens.breedlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import com.android.boilerplate.ui.theme.CardColor
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
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
    ) {
        items(breedList.list) {
            BreedCard(breed = it, onCardClick = onCardClick)
        }
    }
}

@Composable
fun BreedCard(breed: Breed, onCardClick: (id: String) -> Unit) {
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
            IconButton(onClick = {
                onCardClick(breed.id)
            }) {

            }
        }
    }
}



