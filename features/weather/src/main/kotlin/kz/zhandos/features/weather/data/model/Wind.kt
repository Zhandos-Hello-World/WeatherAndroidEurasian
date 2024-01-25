package kz.zhandos.features.weather.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    @SerialName("deg")
    val deg: Int,
    @SerialName("gust")
    val gust: Double = 0.0,
    @SerialName("speed")
    val speed: Double
)