package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.mappers.toWeatherInfo
import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
        Resource.Success(
                 data = api.getWeatherData(
                     lat = lat,
                     long = long
                 ).toWeatherInfo()
        )
        } catch (e : Exception) {
            e.printStackTrace()
            println(e.stackTraceToString())
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}