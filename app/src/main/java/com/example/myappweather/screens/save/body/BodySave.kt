package com.example.myappweather.screens.save.body

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.utils.MyEspacer
import com.example.myappweather.utils.isValidDate
import com.example.proyecto_app.viewModel.SaveViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BodySave(
    modifier: Modifier,
    saveViewModel: SaveViewModel,
    date: String,
    temperature: String,
    isDateError: Boolean,
    isTemperatureError: Boolean,
    dateFocusRequester: FocusRequester,
    temperatureFocusRequester: FocusRequester,
    showDialog: Boolean,
    saveSuccessful: Boolean,
    scope: CoroutineScope,
    dataStoreManager: DataStoreManager
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text= "¡Guarda la temperatura",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text= "de hoy!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        MyEspacer(60.dp)
        DateText(date, isDateError, dateFocusRequester)
        {
            saveViewModel.onValueChange(date = it, temperature)
        }
        MyEspacer(20.dp)
        TemperaturaText(temperature, isTemperatureError, temperatureFocusRequester)
        {
            saveViewModel.onValueChange(date, temperature = it)
        }
        MyEspacer(20.dp)
        ButtonSave {
            saveViewModel.onErrorChange(date, temperature)

            // Dar el foco al que está vacío.
            if (isDateError) {
                dateFocusRequester.requestFocus()
            }
            if (isTemperatureError) {
                temperatureFocusRequester.requestFocus()
            } else {
                if (isValidDate(date)) {
                    scope.launch {  // Lanza el guardado de los datos en otro hilo para evitar bloqueos
                        dataStoreManager.saveTemperatureForDate(date, temperature)
                    }
                    saveViewModel.changeSuccessful(true)
                    saveViewModel.changeShowDialog(true)
                }
                else {
                    saveViewModel.changeShowDialog(true)
                }
            }
        }

        if (showDialog) {
            DialogSave(saveSuccessful, date, temperature)
            {
                // Limpiar los campos y mover el foco.
                if (saveSuccessful) {
                    saveViewModel.onValueChange("", "")
                } else {
                    saveViewModel.onValueChange("", temperature)
                }
                saveViewModel.changeSuccessful(false)
                dateFocusRequester.requestFocus()
                saveViewModel.changeShowDialog(false)
            }
        }
    }
}