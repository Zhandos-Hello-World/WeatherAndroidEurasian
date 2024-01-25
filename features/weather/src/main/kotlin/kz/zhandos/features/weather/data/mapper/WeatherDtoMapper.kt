package kz.zhandos.features.weather.data.mapper

import kz.zhandos.features.weather.data.model.WeatherCurrentResponse
import kz.zhandos.features.weather.domain.model.WeatherCurrent
import kz.zhandos.lib.core.Mapper

class WeatherDtoMapper : Mapper<WeatherCurrentResponse, WeatherCurrent> {

    override fun map(from: WeatherCurrentResponse): WeatherCurrent {
        return WeatherCurrent(
            temp = from.main.temp.toInt(),
            tempFeels = from.main.feelsLike.toInt(),
            description = from.weather.first().main,
            dateAndTime = from.dt.toLong(),
            windSpeed = from.wind.speed.toInt(),
            humidity = from.main.humidity,
            pressure = from.main.pressure,
            seaLevel = from.main.seaLevel,
            sunset = from.sys.sunset.toLong(),
            sunrise = from.sys.sunrise.toLong(),
        )
    }
}