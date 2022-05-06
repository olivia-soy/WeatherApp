package com.olivia.weatherapp.domain.repository

import com.olivia.weatherapp.domain.model.LocationModel

/**
 * # WeatherApp
 * # weather repository
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
interface WeatherRepository {
    suspend fun requestLocationSearch(query: String): List<Int>
    suspend fun requestLocation(woeid: Int): LocationModel
}