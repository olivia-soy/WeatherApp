package com.olivia.weatherapp.data.di

import com.olivia.weatherapp.data.repositoryimpl.WeatherRepositoryImpl
import com.olivia.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * # WeatherApp
 * # NetworkModule
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun providesWeatherRepository(weatherRepository: WeatherRepositoryImpl): WeatherRepository {
        return weatherRepository
    }
}