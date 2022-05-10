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
        requestWeatherSearch()
    }

    private fun requestWeatherSearch() {
        viewModelScope.launch {
            _dataLoading.value = true
            val response = withContext(Dispatchers.IO) {
                try {
                    repository.requestLocationSearch(location_query)
                } catch (e: Exception) {
                    null
                }
            }

            if (!response.isNullOrEmpty()) {
                _weatherList.value = requestWeatherLocation(response)
            }

            _dataLoading.value = false
        }
    }

    private suspend fun requestWeatherLocation(idList: List<Int>) = withContext(Dispatchers.IO) {
        idList.map {
            async {
                try {
                    repository.requestLocation(it)
                } catch (e: Exception) {
                    LocationModel()
                }
            }
        }.awaitAll()
    }

    fun refresh() {
        requestWeatherSearch()
    }

    companion object {
        private const val location_query = "se"
    }
}