package com.android.boilerplate.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.boilerplate.config.Routes
import com.android.boilerplate.ui.screens.breedlist.BreedListScreen
import com.android.boilerplate.ui.screens.splash.SplashScreen

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH.name) {
        composable(Routes.SPLASH.name) {
            SplashScreen(navController)
        }
        composable(Routes.BREED_LIST.name) {
            BreedListScreen(navController)
        }
    }
}