package com.android.boilerplate.ui.common

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ScreenContainer(
    title: String = "",
    navController: NavHostController,
    topBar: @Composable () -> Unit = {
        AppBar(title = title, navigateUp = {
            navController.popBackStack()
        })
    },
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
    ) {
        Surface(
            modifier = Modifier
                .consumeWindowInsets(it)
                .fillMaxSize(),
            content = content
        )
    }
}