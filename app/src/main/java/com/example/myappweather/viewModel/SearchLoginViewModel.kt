package com.example.myappweather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchLoginViewModel: ViewModel() {

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _isDateError = MutableLiveData<Boolean>()
    val isDateError: LiveData<Boolean> = _isDateError

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    fun onValueChange(date: String) {
        _date.value = date
    }

    fun onErrorChange(date: String) {
        _isDateError.value = date.isEmpty()
    }

    fun changeShowDialog(show: Boolean) {
        _showDialog.value = show
    }
}