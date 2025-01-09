package com.example.proyecto_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaveLoginViewModel: ViewModel() {

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _temperature = MutableLiveData<String>()
    val temperature: LiveData<String> = _temperature

    private val _isDateError = MutableLiveData<Boolean>()
    val isDateError: LiveData<Boolean> = _isDateError

    private val _isTemperatureError = MutableLiveData<Boolean>()
    val isTemperatureError: LiveData<Boolean> = _isTemperatureError

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _saveSuccessful = MutableLiveData<Boolean>()
    val saveSuccessful: LiveData<Boolean> = _saveSuccessful

    fun onValueChange(date: String, temperature: String) {
        _date.value = date
        _temperature.value = temperature
    }

    fun onErrorChange(date: String, temperature: String) {
        _isDateError.value = date.isEmpty()
        _isTemperatureError.value = temperature.isEmpty()
    }

    fun changeShowDialog(show: Boolean){
        _showDialog.value = show
    }

    fun changeSuccessful(success: Boolean) {
        _saveSuccessful.value = success
    }
}