package com.olivia.weatherapp.data.repositoryimpl

import com.olivia.weatherapp.data.retrofit.api.WeatherApi
import com.olivia.weatherapp.data.retrofit.response.LocationResponseData
import com.olivia.weatherapp.data.retrofit.response.LocationSearchResponseData
import com.olivia.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

/**
 * # WeatherApp
 * # WeatherRepositoryImpl
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun requestLocationSearch(query: String): LocationSearchResponseData =
        weatherApi.locationSearch(query)

    override suspend fun requestLocation(woeid: String): LocationResponseData =
        weatherApi.location(woeid)
}