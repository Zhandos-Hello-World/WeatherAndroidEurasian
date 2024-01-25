package kz.zhandos.features.weather.presentation.list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.zhandos.features.weather.domain.model.WeatherCurrentParams
import kz.zhandos.features.weather.domain.repository.WeatherRepository
import kz.zhandos.features.weather.presentation.mapper.WeatherListDvoMapper
import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.coreui.base.BaseViewModel
import kz.zhandos.lib.coreui.base.ViewState

class WeatherListViewModel(
    private val launcher: WeatherListLauncher,
    private val repository: WeatherRepository,
    private val mapper: WeatherListDvoMapper,
) : BaseViewModel() {
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getWeatherList()
    }

    fun getWeatherList() {
        val gps = launcher.selectedCity.gps
        dataRequest(
            dispatcher = Dispatchers.IO,
            loading = { loading ->
                if (loading) {
                    _uiState.tryEmit(ViewState.Loading)
                }
            },
            request = {
                repository.getWeatherList(
                    WeatherCurrentParams(
                        latitude = gps.latitude,
                        longitude = gps.longitude,
                    )
                )
            },
            onSuccess = { response ->
                _uiState.tryEmit(
                    ViewState.Data(
                        mapper.map(response)
                    )
                )
            },
            onError = {
                _uiState.tryEmit(ViewState.Error)
            },
        )
    }

    fun backToScreen() {
        router.exit()
    }

}