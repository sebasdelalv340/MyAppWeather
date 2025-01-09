package com.example.myappweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myappweather.data.DataStoreManager
import com.example.myappweather.navigation.AppNavigation
import com.example.myappweather.ui.theme.MyAppWeatherTheme
import com.example.proyecto_app.viewModel.SaveLoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val saveLoginViewModel = SaveLoginViewModel()
            val dataStoreManager = DataStoreManager(applicationContext)
            MyAppWeatherTheme {
                AppNavigation(saveLoginViewModel, dataStoreManager)
            }
        }
    }
}
