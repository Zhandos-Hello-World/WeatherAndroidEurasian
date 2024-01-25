package kz.zhandos.features.weather.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityDvo(
    val name: String,
    val gps: GpsLocationDvo,
) : Parcelable {

    @Parcelize
    data class GpsLocationDvo(
        val latitude: Double,
        val longitude: Double,
    ) : Parcelable
}