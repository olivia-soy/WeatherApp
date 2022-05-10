package com.olivia.weatherapp.domain.model

/**
 * WeatherApp
 * ConsolidatedWeatherModel
 * @author leesoyoung
 * @since 2022/05/06
 */

data class LocationModel(
    val id: Int = 0,
    val title: String = "",
    val todayWeather: ConsolidatedWeatherModel? = null,
    val tomorrowWeather: ConsolidatedWeatherModel? = null
)