package com.android.boilerplate.ui.common

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
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
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding(),
                start = it.calculateStartPadding(layoutDirection = LayoutDirection.Rtl),
                end = it.calculateEndPadding(layoutDirection = LayoutDirection.Rtl)
            ),
            content = content
        )
    }
}