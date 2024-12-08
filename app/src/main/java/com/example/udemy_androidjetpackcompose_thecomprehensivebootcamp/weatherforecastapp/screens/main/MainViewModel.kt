package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.data.DataOrException
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Weather
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository):ViewModel() {
    suspend fun getWeatherData(city:String):DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather(cityQuery = city)
    }
}