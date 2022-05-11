package com.olivia.weatherapp.data.repositoryimpl

import com.olivia.weatherapp.data.mapper.toConsolidatedWeatherModel
import com.olivia.weatherapp.data.retrofit.api.WeatherApi
import com.olivia.weatherapp.domain.Result
import com.olivia.weatherapp.domain.model.LocationModel
import com.olivia.weatherapp.domain.repository.WeatherRepository
import com.olivia.weatherapp.domain.safeFlow
import kotlinx.coroutines.flow.Flow
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
    override fun requestLocationSearch(query: String): Flow<Result<List<Int>>> = safeFlow {
        weatherApi.locationSearch(query).map {
            it.woeid
        }
    }

    override suspend fun requestLocation(woeid: Int): LocationModel {
        val response = weatherApi.location(woeid.toString())
        return LocationModel(
            id = response.woeid,
            title = response.title,
            todayWeather = response.consolidated_weather.getOrNull(0)?.toConsolidatedWeatherModel(),
            tomorrowWeather = response.consolidated_weather.getOrNull(1)
                ?.toConsolidatedWeatherModel(),
        )
    }
}