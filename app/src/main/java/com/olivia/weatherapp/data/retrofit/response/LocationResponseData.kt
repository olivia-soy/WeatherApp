package com.olivia.weatherapp.data.retrofit.response

/**
 * # WeatherApp
 * # LocationResponseData
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
data class LocationResponseData(
    val consolidated_weather: List<ConsolidatedWeather>,
    val latt_long: String,
    val location_type: String,
    val parent: Parent,
    val sources: List<Source>,
    val sun_rise: String,
    val sun_set: String,
    val time: String,
    val timezone: String,
    val timezone_name: String,
    val title: String,
    val woeid: Int
)