package com.olivia.weatherapp.domain.repository

import com.olivia.weatherapp.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow
import com.olivia.weatherapp.domain.Result

/**
 * # WeatherApp
 * # weather repository
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
interface WeatherRepository {
    fun requestLocationSearch(query: String): Flow<Result<List<Int>>>
    suspend fun requestLocation(woeid: Int): LocationModel
}