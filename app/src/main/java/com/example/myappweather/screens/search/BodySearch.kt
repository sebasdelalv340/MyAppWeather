package com.example.myappweather.screens.search

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.screens.save.body.DateText
import com.example.myappweather.utils.MyEspacer
import com.example.myappweather.utils.isValidDate
import com.example.myappweather.viewModel.SearchLoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BodySearch(
    modifier: Modifier,
    searchLoginViewModel: SearchLoginViewModel,
    date: String,
    isDateError: Boolean,
    dateFocusRequester: FocusRequester,
    showDialog: Boolean,
    scope: CoroutineScope,
    dataStoreManager: DataStoreManager
) {
    var temperatureResult by remember { mutableStateOf<String>("No disponible") }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = temperatureResult,
            style = MaterialTheme.typography.displayMedium
        )
        MyEspacer(60.dp)
        Text(
            text= "¡Buscar la temperatura",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text= "por fecha!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        MyEspacer(60.dp)
        DateText(date, isDateError, dateFocusRequester)
        {
            searchLoginViewModel.onValueChange(date = it)
        }
        MyEspacer(20.dp)
        ButtonSearch {
            searchLoginViewModel.onErrorChange(date)

            // Dar el foco al que está vacío.
            if (isDateError) {
                dateFocusRequester.requestFocus()
            } else {
                if (isValidDate(date)) {
                    scope.launch {
                        dataStoreManager.getTemperatureForDate(date).collect { temperature ->
                            temperatureResult = temperature ?: "No hay datos para esta fecha"
                        }
                    }
                } else {
                    searchLoginViewModel.changeShowDialog(true)
                }
            }
        }

        if (showDialog) {
            DialogSearch(date)
            {
                // Limpiar los campos y mover el foco.
                searchLoginViewModel.onValueChange("")
                dateFocusRequester.requestFocus()
                searchLoginViewModel.changeShowDialog(false)
            }
        }
    }
}