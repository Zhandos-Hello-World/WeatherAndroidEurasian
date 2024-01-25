package kz.zhandos.features.weather.data.repository

import kz.zhandos.features.weather.data.api.WeatherAPI
import kz.zhandos.features.weather.data.mapper.WeatherDtoMapper
import kz.zhandos.features.weather.data.mapper.WeatherItemDtoMapper
import kz.zhandos.features.weather.domain.model.WeatherCurrent
import kz.zhandos.features.weather.domain.model.WeatherCurrentParams
import kz.zhandos.features.weather.domain.model.WeatherItem
import kz.zhandos.features.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherAPI,
    private val mapper: WeatherDtoMapper,
    private val listMapper: WeatherItemDtoMapper,
) : WeatherRepository {

    override suspend fun getCurrentWeather(params: WeatherCurrentParams): WeatherCurrent {
        return mapper.map(
            api.getCurrentWeather(
                lat = params.latitude,
                lon = params.longitude,
                units = params.units,
                mode = params.mode,
                lang = params.lang,
            )
        )
    }

    override suspend fun getWeatherList(params: WeatherCurrentParams): List<WeatherItem> {
        return listMapper.map(
            api.getWeatherList(
                lat = params.latitude,
                lon = params.longitude,
                units = params.units,
                mode = params.mode,
                lang = params.lang,
            )
        )
    }
}