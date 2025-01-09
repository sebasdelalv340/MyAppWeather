package com.example.myappweather.screens.save.body

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp

@Composable
fun TemperaturaText(
    temperature: String,
    isError: Boolean,
    focusRequester: FocusRequester,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .width(310.dp)
            .focusRequester(focusRequester),
        value = temperature,
        onValueChange = onValueChanged,
        label = { Text("Temperatura") },
        singleLine = true
    )
    if (isError) {
        Text(
            text = "El campo temperatura no puede estar vacío",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}