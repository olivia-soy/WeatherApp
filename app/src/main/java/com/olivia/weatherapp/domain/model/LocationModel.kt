package com.olivia.weatherapp.domain.model

/**
 * WeatherApp
 * ConsolidatedWeatherModel
 * @author leesoyoung
 * @since 2022/05/06
 */

data class LocationModel(
    val id: Int,
    val title: String,
    val todayWeather: ConsolidatedWeatherModel?,
    val tomorrowWeather: ConsolidatedWeatherModel?
)