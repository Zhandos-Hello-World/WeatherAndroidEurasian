package kz.zhandos.features.weather.domain.repository

import kz.zhandos.features.weather.domain.model.WeatherCurrent
import kz.zhandos.features.weather.domain.model.WeatherCurrentParams
import kz.zhandos.features.weather.domain.model.WeatherItem

interface WeatherRepository {

    suspend fun getCurrentWeather(params: WeatherCurrentParams): WeatherCurrent

    suspend fun getWeatherList(params: WeatherCurrentParams): List<WeatherItem>
}