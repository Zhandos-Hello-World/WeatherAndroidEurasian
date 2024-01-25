package kz.zhandos.features.weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherItemResponse(
    @SerialName("dt") val dt: Long,
    @SerialName("main") val main: Main,
    @SerialName("weather") val weather: List<Weather>,
    @SerialName("clouds") val clouds: Clouds,
    @SerialName("wind") val wind: Wind,
    @SerialName("dt_txt") val dateText: String,
)