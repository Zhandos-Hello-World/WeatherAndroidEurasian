package kz.zhandos.features.weather.presentation.model

data class WeatherItemDvo(
    val id: Long,
    val tempMin: String,
    val tempMax: String,
    val time: String,
    val status: String,
    val feelsLike: String,
    val temp: String,
)