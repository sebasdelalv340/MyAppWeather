package com.example.myappweather.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.screens.save.SaveTemperature
import com.example.myappweather.screens.search.SearchTemperature
import com.example.proyecto_app.viewModel.SaveLoginViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(saveLoginViewModel: SaveLoginViewModel, dataStoreManager: DataStoreManager) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = "save") {
        composable("save") {
            SaveTemperature(navControlador, saveLoginViewModel, dataStoreManager)
        }
        composable("search")
        {
            SearchTemperature(navControlador, saveLoginViewModel, dataStoreManager)
        }

    }
}