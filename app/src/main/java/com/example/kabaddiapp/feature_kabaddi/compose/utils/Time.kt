package com.example.kabaddiapp.feature_kabaddi.compose.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate():String{
    val sdf = SimpleDateFormat("HH:mm")
    return sdf.format(Date())
}
