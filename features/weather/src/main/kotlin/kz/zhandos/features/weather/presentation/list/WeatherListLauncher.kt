package kz.zhandos.features.weather.presentation.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.zhandos.features.weather.presentation.model.CityDvo

@Parcelize
data class WeatherListLauncher(
    val selectedCity: CityDvo,
) : Parcelable