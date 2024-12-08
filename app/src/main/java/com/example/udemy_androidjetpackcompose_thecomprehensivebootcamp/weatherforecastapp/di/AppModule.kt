package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.di

import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.network.WeatherApi
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideOpenWeatherApi():WeatherApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}