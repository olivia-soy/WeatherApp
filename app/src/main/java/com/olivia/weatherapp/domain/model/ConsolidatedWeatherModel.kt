package com.olivia.weatherapp.domain.model

/**
 * WeatherApp
 * ConsolidatedWeatherModel
 * @author leesoyoung
 * @since 2022/05/06
 */

data class ConsolidatedWeatherModel(
    val weather_state_name: String,
    val weather_image_url: String,
    val the_temp: String,
    val humidity: String,
)