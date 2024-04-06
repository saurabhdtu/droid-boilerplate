package com.android.boilerplate.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.boilerplate.R
import com.android.boilerplate.config.Screen
import com.android.boilerplate.config.createRoute
import com.android.boilerplate.ui.common.AppBar
import com.android.boilerplate.ui.common.ScreenContainer

@Composable
fun SplashScreen(navController: NavHostController) {
    ScreenContainer(
        navController = navController,
        topBar = { AppBar(title = "Splash", canNavigateBack = false) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.height(45.dp)) {
                Button(onClick = {
                    navController.navigate(Screen.BreedList.createRoute())
                }) {
                    Text(text = stringResource(id = R.string.android))
                }
            }
        }
    }

}