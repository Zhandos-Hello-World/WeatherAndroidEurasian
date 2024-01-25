package kz.zhandos.features.weather.domain.model

data class WeatherCurrentParams(
    val latitude: Double,
    val longitude: Double,
    val units: String = DEFAULT_UNITS,
    val mode: String = DEFAULT_MODE,
    val lang: String = DEFAULT_LANG,
) {

    companion object {
        const val DEFAULT_UNITS = "metric"
        const val DEFAULT_MODE = "json"
        const val DEFAULT_LANG = "en"
    }
}