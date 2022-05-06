package com.olivia.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivia.weatherapp.domain.model.LocationModel
import com.olivia.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * # WeatherApp
 * # WeatherViewModel
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherList: MutableStateFlow<List<LocationModel>> = MutableStateFlow(
        listOf()
    )
    val weatherList: StateFlow<List<LocationModel>> = _weatherList


    private val _dataLoading = MutableStateFlow(false)
    val dataLoading: MutableStateFlow<Boolean>
        get() = _dataLoading

    init {
        requestWeatherList()
    }

    private fun requestWeatherList() {
        viewModelScope.launch {
            _dataLoading.value = true
            val response = withContext(Dispatchers.IO) {
                repository.requestLocationSearch("se")
            }
            val list = arrayListOf<LocationModel>()
            response.map {
                async(Dispatchers.IO) {
                    list.add(repository.requestLocation(it))
                }
            }.awaitAll()

            _weatherList.value = list
            _dataLoading.value = false
        }
    }

    fun refresh() {
        requestWeatherList()
    }
}