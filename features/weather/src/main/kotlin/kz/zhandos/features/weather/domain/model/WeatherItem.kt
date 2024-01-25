package kz.zhandos.features.weather.domain.model

data class WeatherItem(
    val tempMin: Int,
    val tempMax: Int,
    val time: Long,
    val status: String,
    val temp: Int,
    val tempFeels: Int,
)