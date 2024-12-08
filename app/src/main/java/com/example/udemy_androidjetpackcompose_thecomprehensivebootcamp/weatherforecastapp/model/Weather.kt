package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model

data class Weather(
    val city:City,
    val cnt:Int,
    val cod:String,
    val list:List<WeatherItem>,
    val message:Double
)
