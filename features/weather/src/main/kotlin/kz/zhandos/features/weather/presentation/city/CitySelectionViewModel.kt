package kz.zhandos.features.weather.presentation.city

import kz.zhandos.features.weather.presentation.details.WeatherDetailsLauncher
import kz.zhandos.features.weather.presentation.factory.CityFactory
import kz.zhandos.features.weather.presentation.model.CityDvo
import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.coreui.base.BaseViewModel

class CitySelectionViewModel(
    private val factory: CityFactory,
) : BaseViewModel() {

    fun getCities(): List<CityDvo> {
        return factory.createCityList()
    }

    fun navigateToCurrentFragment(dvo: CityDvo) {
        router.navigateTo(
            Screens.ScreenWeatherDetails(
                launcher =
                WeatherDetailsLauncher(
                    dvo = dvo,
                ),
            ),
        )
    }
}