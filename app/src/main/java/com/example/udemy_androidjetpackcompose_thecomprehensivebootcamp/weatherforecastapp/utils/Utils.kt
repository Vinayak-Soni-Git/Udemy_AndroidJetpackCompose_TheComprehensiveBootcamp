package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(timeStamp: Int): String {
    val simpleDateFormat = SimpleDateFormat("EEE, MMM d", Locale.ENGLISH)
    val date = Date(timeStamp.toLong() * 1000)

    return simpleDateFormat.format(date)
}

fun formatDateTime(timeStamp: Int): String {
    val simpleDateFormat = SimpleDateFormat("hh:mm:aa", Locale.ENGLISH)
    val date = Date(timeStamp.toLong() * 1000)

    return simpleDateFormat.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}