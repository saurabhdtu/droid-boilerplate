package com.android.boilerplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.boilerplate.ui.AppRoute
import com.android.boilerplate.ui.theme.DroidBoilerplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            DroidBoilerplateTheme {
                AppRoute()
            }
        }
    }
}
