package com.android.boilerplate.ui.screens.breeddetail

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.android.boilerplate.ui.common.ScreenContainer
import org.koin.compose.koinInject

@Composable
fun BreedDetailScreen(navController: NavHostController, breedId: String) {
    val breedDetailViewModel= koinInject<BreedDetailViewModel>()
    ScreenContainer(navController = navController, title = "Breed Detail") {

    }
}