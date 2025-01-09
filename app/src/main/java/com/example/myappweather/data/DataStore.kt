package com.example.myappweather.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "weather_prefs")

class DataStoreManager(private val context: Context) {
    // Guardar temperatura asociada a una fecha
    suspend fun saveTemperatureForDate(date: String, temperature: String) {
        val key = stringPreferencesKey(date)
        context.dataStore.edit { preferences ->
            preferences[key] = temperature
        }
    }

    // Obtener temperatura por fecha
    fun getTemperatureForDate(date: String): Flow<String?> {
        val key = stringPreferencesKey(date)
        return context.dataStore.data
            .map { preferences -> preferences[key] }
    }
}