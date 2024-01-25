package kz.zhandos.features.weather.presentation.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import kz.zhandos.features.weather.presentation.city.CitySelectionFragment
import kz.zhandos.features.weather.presentation.details.WeatherDetailsFragment
import kz.zhandos.features.weather.presentation.details.WeatherDetailsLauncher
import kz.zhandos.features.weather.presentation.list.WeatherListFragment
import kz.zhandos.features.weather.presentation.list.WeatherListLauncher

object Screens {
    fun CitySelection() = FragmentScreen { CitySelectionFragment() }
    fun ScreenWeatherDetails(launcher: WeatherDetailsLauncher) = FragmentScreen("Details_$launcher") { WeatherDetailsFragment(launcher) }
    fun ScreenListWeather(launcher: WeatherListLauncher) = FragmentScreen("List_$launcher") { WeatherListFragment(launcher) }
}