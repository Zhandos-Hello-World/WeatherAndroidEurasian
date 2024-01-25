package kz.zhandos.features.weather.presentation.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.zhandos.features.weather.presentation.model.CityDvo

@Parcelize
class WeatherDetailsLauncher(
    val dvo: CityDvo,
) : Parcelable