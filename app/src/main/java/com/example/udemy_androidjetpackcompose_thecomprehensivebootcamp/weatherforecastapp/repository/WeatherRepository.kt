package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.repository

import android.util.Log
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.data.DataOrException
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Weather
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(
        cityQuery: String,
        units: String
    ): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery, units = units)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")
        return DataOrException(data = response)
    }
}