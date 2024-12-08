package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model

data class WeatherItem(
    val clouds:Int,
    val deg:Int,
    val dt:Int,
    val feelsLike:FeelsLike,
    val gust:Double,
    val humidity:Double,
    val pop:Double,
    val pressure:Int,
    val rain:Double,
    val speed:Double,
    val sunrise:Int,
    val sunset:Int,
    val temp:Temp,
    val weather:List<WeatherObject>
)
