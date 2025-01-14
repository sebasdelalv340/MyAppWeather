package com.example.myappweather.screens.search

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.screens.save.MyHeader
import com.example.myappweather.viewModel.SearchViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchTemperature(navController: NavController, searchViewModel: SearchViewModel, dataStoreManager: DataStoreManager) {
    val date by searchViewModel.date.observeAsState("")

    // Para gestionar los campos vacíos
    val isDateError by searchViewModel.isDateError.observeAsState(false)

    // Para gestionar la AlertDialog
    val showDialog by searchViewModel.showDialog.observeAsState(false)

    // Para gestionar el foco
    val dateFocusRequester = remember { FocusRequester() }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        MyHeader( "My Weather", Icons.Default.Create) {
            navController.navigate("save")
        }
        BodySearch(
            Modifier.weight(1f),
            searchViewModel,
            date,
            isDateError,
            dateFocusRequester,
            showDialog,
            scope,
            dataStoreManager
        )
    }
}