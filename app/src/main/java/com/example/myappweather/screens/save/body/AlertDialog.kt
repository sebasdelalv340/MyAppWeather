package com.example.myappweather.screens.save.body

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogSave(success: Boolean, date: String, temperature: String, onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = if (success) "Guardado existoso" else "Guardado Fallido")
        },
        text = {
            Text(text = if (success) "Temperatura para $date : ${temperature}ºC" else "Formato fecha incorrecto.\ndd/MM/yyyy")
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