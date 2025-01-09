package com.example.myappweather.screens.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonSearch(onClick:()-> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 100.dp, vertical = 15.dp)
    ) {
        Text(
            text = "Buscar",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}