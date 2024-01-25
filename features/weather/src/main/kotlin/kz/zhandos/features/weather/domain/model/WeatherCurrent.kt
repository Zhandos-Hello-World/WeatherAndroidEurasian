package kz.zhandos.features.weather.domain.model

data class WeatherCurrent(
    val temp: Int,
    val tempFeels: Int,
    val description: String,
    val dateAndTime: Long,
    val windSpeed: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val sunrise: Long,
    val sunset: Long,
)
