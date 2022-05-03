package com.olivia.weatherapp.data.retrofit.response

/**
 * # WeatherApp
 * # Parent
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
data class Parent(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)