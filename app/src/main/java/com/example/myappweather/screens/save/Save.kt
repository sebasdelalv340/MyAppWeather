package com.example.myappweather.screens.save

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.screens.save.body.BodySave
import com.example.proyecto_app.viewModel.SaveViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SaveTemperature(navController: NavController, saveViewModel: SaveViewModel, dataStoreManager: DataStoreManager) {
    val date by saveViewModel.date.observeAsState("")
    val temperature by saveViewModel.temperature.observeAsState("")

    // Para gestionar los campos vacíos
    val isDateError by saveViewModel.isDateError.observeAsState(false)
    val isTemperatureError by saveViewModel.isTemperatureError.observeAsState(false)

    // Para gestionar la AlertDialog
    val showDialog by saveViewModel.showDialog.observeAsState(false)

    // Para gestionar el foco
    val dateFocusRequester = remember { FocusRequester() }
    val temperatureFocusRequester = remember { FocusRequester() }

    // Para gestionar el mensaje en la Alerta de diálogo
    val saveSuccessfull by saveViewModel.saveSuccessful.observeAsState(false)

    val scope = rememberCoroutineScope()


    Column(modifier = Modifier.fillMaxSize()) {
        MyHeader("My Weather", Icons.Default.Search) { navController.navigate("search") }
        BodySave(
            Modifier.weight(1f),
            saveViewModel,
            date,
            temperature,
            isDateError,
            isTemperatureError,
            dateFocusRequester,
            temperatureFocusRequester,
            showDialog,
            saveSuccessfull,
            scope,
            dataStoreManager
        )
    }

}



