package kz.zhandos.features.weather.presentation.model

data class WeatherDvo(
    val temp: String,
    val feelsLike: String,
    val status: String,
    val dateAndTime: String,
    val windSpeed: String,
    val humidity: String,
    val pressure: String,
    val seaLevel: String,
    val sunrise: String,
    val sunset: String,
)