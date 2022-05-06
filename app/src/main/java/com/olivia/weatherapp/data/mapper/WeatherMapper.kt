package com.olivia.weatherapp.data.mapper

import com.olivia.weatherapp.data.retrofit.response.ConsolidatedWeather
import com.olivia.weatherapp.domain.model.ConsolidatedWeatherModel

/**
 * WeatherApp
 * weather mapper
 * @author leesoyoung
 * @since 2022/05/06
 */

fun ConsolidatedWeather.toConsolidatedWeatherModel() =
    ConsolidatedWeatherModel(
        weather_state_name = this.weather_state_name,
        weather_image_url = "https://www.metaweather.com/static/img/weather/png/${this.weather_state_abbr}.png",
        the_temp = "${this.the_temp.toInt()}ºC",
        humidity = "${this.humidity}%"
    )
