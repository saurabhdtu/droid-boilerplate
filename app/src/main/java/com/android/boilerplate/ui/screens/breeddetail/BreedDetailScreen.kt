package com.android.boilerplate.ui.screens.breeddetail

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.android.boilerplate.R
import com.android.boilerplate.ui.common.AppLoader
import com.android.boilerplate.ui.common.ErrorPage
import com.android.boilerplate.ui.common.ScreenContainer
import org.koin.compose.koinInject

@Composable
fun BreedDetailScreen(navController: NavHostController, breedId: String) {
    val breedDetailViewModel = koinInject<BreedDetailViewModel>()
    val state by breedDetailViewModel.stateFlow.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        breedDetailViewModel.loadBreedDetail(breedId)
    }
    when (state) {
        is BreedDetailState.Error -> ErrorPage(retry = {
            breedDetailViewModel.loadBreedDetail(
                breedId
            )
        }, errorMessage = (state as BreedDetailState.Error).message)

        is BreedDetailState.Loaded -> {
            val breedDetail = (state as BreedDetailState.Loaded).breed
            ScreenContainer(
                navController = navController,
                title = breedDetail.breed.attributes.name
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(stringResource(R.string.about_the_dog), fontSize = 18.sp, style = MaterialTheme.typography.titleMedium)
                    Text(breedDetail.breed.attributes.description, fontSize = 14.sp)
                    BreedAttributeCard(
                        title = stringResource(R.string.life_expectancy),
                        breedDetail.breed.attributes.life?.min?.toString() ?: "",
                        breedDetail.breed.attributes.life?.max?.toString() ?: ""
                    )
                    BreedAttributeCard(
                        title = stringResource(R.string.male_weight),
                        breedDetail.breed.attributes.maleWeight?.min?.toString() ?: "",
                        breedDetail.breed.attributes.maleWeight?.max?.toString() ?: ""
                    )
                    BreedAttributeCard(
                        title = stringResource(R.string.female_weight),
                        breedDetail.breed.attributes.femaleWeight?.min?.toString() ?: "",
                        breedDetail.breed.attributes.femaleWeight?.max?.toString() ?: ""
                    )
                }
            }

        }

        BreedDetailState.Loading -> ScreenContainer(
            navController = navController,
            title = "Loading..."
        ) {
            AppLoader()
        }
    }
}

@Composable
fun BreedAttributeCard(title: String, lowerValue: String, higherValue: String) {
    Column {
        Text(title, fontSize = 18.sp, style = MaterialTheme.typography.headlineMedium)
        Text(stringResource(R.string.minimum), fontSize = 16.sp, style = MaterialTheme.typography.bodyMedium)
        Text(lowerValue, fontSize = 14.sp)
        Text(stringResource(R.string.maximum), fontSize = 16.sp, style = MaterialTheme.typography.bodyMedium)
        Text(higherValue, fontSize = 14.sp)
    }

}

