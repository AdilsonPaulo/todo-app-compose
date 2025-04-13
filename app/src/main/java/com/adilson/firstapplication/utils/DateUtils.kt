package com.adilson.firstapplication.utils

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun LocalDate.formatToString(): String{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return this.format(formatter)
}