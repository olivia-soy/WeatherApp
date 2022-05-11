package com.olivia.weatherapp.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * # WeatherApp
 * #
 * @author LEESOYOUNG
 * @since 2022-05-11
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Empty : Result<Nothing>()
}

fun <T> safeFlow(apiCall: suspend () -> T): Flow<Result<T>> = flow {
    try {
        emit(Result.Success(apiCall.invoke()))
    } catch (e: Exception) {
        emit(Result.Error(exception = e))
    }
}