package com.olivia.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivia.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * # WeatherApp
 * # WeatherViewModel
 * @author LEESOYOUNG
 * @since 2022-05-03
 */
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    init {

        viewModelScope.launch {
            val response = repository.requestLocationSearch("se")
            Log.d("soy", "response : $response")
        }
    }
}