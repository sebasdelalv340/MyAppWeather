package com.example.myappweather.screens.search

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogSearch(date: String, onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Error")
        },
        text = {
            Text(text = "Formato fecha $date incorrecto.\ndd/MM/yyyy")
        },
        confirmButton = {
            Button(
                onClick = onDismiss
            ) {
                Text(text = "Cerrar")
            }
        }
    )
}