package com.example.myappweather.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

// Formato de fecha deseado
@RequiresApi(Build.VERSION_CODES.O)
private val DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy")

@RequiresApi(Build.VERSION_CODES.O)
fun isValidDate(input: String): Boolean {
    return try {
        LocalDate.parse(input, DATE_FORMATTER)
        true
    } catch (e: DateTimeParseException) {
        false
    }
}