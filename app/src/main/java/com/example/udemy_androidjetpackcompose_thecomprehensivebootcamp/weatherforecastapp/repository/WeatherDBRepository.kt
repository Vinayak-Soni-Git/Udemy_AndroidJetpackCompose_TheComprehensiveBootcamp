package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.repository

import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.data.WeatherDao
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Favorite
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDBRepository @Inject constructor(private val weatherDao: WeatherDao) {
    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavourites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavourite(favorite)
    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorites(favorite)
    suspend fun getFavById(city: String): Favorite = weatherDao.getFavById(city)

    fun getUnits():Flow<List<Unit>> = weatherDao.getUnits()
    suspend fun insertUnit(unit: Unit) = weatherDao.insertUnit(unit)
    suspend fun updateUnit(unit: Unit) = weatherDao.updateUnit(unit)
    suspend fun deleteAllUnits() = weatherDao.deleteAllUnits()
    suspend fun deleteUnit(unit: Unit) = weatherDao.deleteUnit(unit)

}