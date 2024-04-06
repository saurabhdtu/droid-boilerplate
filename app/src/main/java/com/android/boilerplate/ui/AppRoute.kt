package com.android.boilerplate.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.boilerplate.config.Screen
import com.android.boilerplate.config.createRoute
import com.android.boilerplate.config.routeName
import com.android.boilerplate.ui.screens.breeddetail.BreedDetailScreen
import com.android.boilerplate.ui.screens.breedlist.BreedListScreen
import com.android.boilerplate.ui.screens.splash.SplashScreen

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.createRoute()) {
        composable(Screen.Splash.routeName()) {
            SplashScreen(navController)
        }
        composable(Screen.BreedList.routeName()) {
            BreedListScreen(navController)
        }
        composable(Screen.BreedDetail.routeName()) {
            val id = it.arguments?.getString("id")
            id?.let { breedId -> BreedDetailScreen(navController, breedId) }
        }
    }
}