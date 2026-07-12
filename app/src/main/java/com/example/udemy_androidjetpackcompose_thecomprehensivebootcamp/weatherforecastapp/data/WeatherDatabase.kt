package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Favorite

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}