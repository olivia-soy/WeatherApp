package com.olivia.weatherapp.data.retrofit.response

/**
 * # WeatherApp
 * # Source
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
data class Source(
    val crawl_rate: Int,
    val slug: String,
    val title: String,
    val url: String
)