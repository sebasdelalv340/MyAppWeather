package com.example.myappweather

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.navigation.AppNavigation
import com.example.myappweather.ui.theme.MyAppWeatherTheme
import com.example.myappweather.viewModel.SearchViewModel
import com.example.proyecto_app.viewModel.SaveViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val saveViewModel = SaveViewModel()
            val searchViewModel = SearchViewModel()
            val dataStoreManager = DataStoreManager(applicationContext)
            MyAppWeatherTheme {
                AppNavigation(saveViewModel, searchViewModel, dataStoreManager)
            }
        }
    }
}
