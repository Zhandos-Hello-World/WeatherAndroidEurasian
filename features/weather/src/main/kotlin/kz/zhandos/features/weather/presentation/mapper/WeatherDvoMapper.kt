package kz.zhandos.features.weather.presentation.mapper

import kz.zhandos.features.weather.domain.model.WeatherCurrent
import kz.zhandos.features.weather.presentation.model.WeatherDvo
import kz.zhandos.lib.core.Mapper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherDvoMapper : Mapper<WeatherCurrent, WeatherDvo> {

    override fun map(from: WeatherCurrent): WeatherDvo {
        return WeatherDvo(
            temp = "${from.temp}°",
            feelsLike = "Feels like ${from.tempFeels}°",
            status = from.description,
            dateAndTime = formatDateFromMillis(from.dateAndTime),
            windSpeed = "${from.windSpeed}km/h",
            humidity = "${from.humidity}%",
            pressure = "${from.pressure} hpa",
            seaLevel = "${from.seaLevel} hpa",
            sunrise = formatHourFromMillis(from.sunrise),
            sunset = formatHourFromMillis(from.sunset),
        )
    }


    private fun formatDateFromMillis(millis: Long): String {
        val date = Date(millis)
        val formatter = SimpleDateFormat("MMMM dd, HH:mm", Locale.getDefault())
        return formatter.format(date)
    }

    private fun formatHourFromMillis(millis: Long): String {
        val date = Date(millis)
        val formatter = SimpleDateFormat("h:mm a", Locale.getDefault())
        return formatter.format(date)
    }
}