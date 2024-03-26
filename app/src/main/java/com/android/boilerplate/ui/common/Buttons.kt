package com.android.boilerplate.ui.common

import android.widget.Button
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.boilerplate.ui.theme.Purple40

@Composable
fun StandardButton(text: String, active:Boolean=true, onClick:()->Unit){
    Button(
        onClick = onClick,
        enabled = active,
        colors = ButtonDefaults.buttonColors(Purple40),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(text = text, fontSize = 12.sp, color = Color.DarkGray)
    }
}