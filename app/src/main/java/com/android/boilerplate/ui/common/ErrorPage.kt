package com.android.boilerplate.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.boilerplate.R

@Composable
fun ErrorPage(retry: () -> Unit, errorMessage: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            errorMessage,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(20.dp)
        )
        Button(onClick = retry) {
            Text(
                stringResource(id = R.string.retry),
                fontSize = 12.sp,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}