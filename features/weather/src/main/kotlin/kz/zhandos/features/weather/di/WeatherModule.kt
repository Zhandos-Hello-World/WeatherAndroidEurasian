package kz.zhandos.features.weather.di

import kz.zhandos.features.weather.data.api.WeatherAPI
import kz.zhandos.features.weather.data.mapper.WeatherDtoMapper
import kz.zhandos.features.weather.data.mapper.WeatherItemDtoMapper
import kz.zhandos.features.weather.data.repository.WeatherRepositoryImpl
import kz.zhandos.features.weather.domain.repository.WeatherRepository
import kz.zhandos.features.weather.presentation.city.CitySelectionViewModel
import kz.zhandos.features.weather.presentation.details.WeatherDetailsViewModel
import kz.zhandos.features.weather.presentation.factory.CityFactory
import kz.zhandos.features.weather.presentation.factory.DefaultCityFactory
import kz.zhandos.features.weather.presentation.list.WeatherListLauncher
import kz.zhandos.features.weather.presentation.list.WeatherListViewModel
import kz.zhandos.features.weather.presentation.mapper.WeatherDvoMapper
import kz.zhandos.features.weather.presentation.mapper.WeatherListDvoMapper
import kz.zhandos.lib.core.data.network.NetworkApiFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {

    single<WeatherAPI> { get<NetworkApiFactory>().createAuthorizedApi() }

    single<WeatherRepository> {
        WeatherRepositoryImpl(
            api = get(),
            mapper = get(),
            listMapper = get(),
        )
    }

    viewModel { (launcher: kz.zhandos.features.weather.presentation.details.WeatherDetailsLauncher) ->
        WeatherDetailsViewModel(
            launcher = launcher,
            repo = get(),
            mapper = get(),
        )
    }
    viewModel { (launcher: WeatherListLauncher) ->
        WeatherListViewModel(
            launcher = launcher,
            repository = get(),
            mapper = get(),
        )
    }

    viewModel {
        CitySelectionViewModel(factory = get<CityFactory>())
    }

    factory<CityFactory> { DefaultCityFactory() }

    factory { WeatherDtoMapper() }

    factory { WeatherDvoMapper() }

    factory { WeatherItemDtoMapper() }

    factory { WeatherListDvoMapper() }

}