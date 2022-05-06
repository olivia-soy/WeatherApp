package com.olivia.weatherapp.data.retrofit.api

import com.olivia.weatherapp.data.retrofit.response.LocationResponseData
import com.olivia.weatherapp.data.retrofit.response.LocationSearchResponseData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * # WeatherApp
 * # Weather api
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
interface WeatherApi {

    @POST("/api/location/search")
    suspend fun locationSearch(
        @Query("query") query: String
    ): LocationSearchResponseData

    @GET("/api/location/{woeid}")
    suspend fun location(
        @Path("woeid") woeid: String
    ): LocationResponseData
}