package com.olivia.weatherapp.domain.repository

import com.olivia.weatherapp.data.retrofit.response.LocationResponseData
import com.olivia.weatherapp.data.retrofit.response.LocationSearchResponseData

/**
 * # WeatherApp
 * # weather repository
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
interface WeatherRepository {
    suspend fun requestLocationSearch(query: String): LocationSearchResponseData
    suspend fun requestLocation(woeid: String): LocationResponseData
}