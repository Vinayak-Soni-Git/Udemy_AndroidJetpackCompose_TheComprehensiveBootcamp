package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.network

import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Weather
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/weather")
    suspend fun getWeather(@Query("q") query: String,
                           @Query("units") units:String = "imperial",
                           @Query("appid") appid:String = Constants.API_KEY):Weather
}