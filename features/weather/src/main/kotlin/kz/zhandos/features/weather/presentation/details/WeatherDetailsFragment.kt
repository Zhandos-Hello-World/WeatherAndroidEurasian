package kz.zhandos.features.weather.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.zhandos.features.weather.databinding.FragmentCurrentWeatherBinding
import kz.zhandos.lib.coreui.base.BaseFragment
import kz.zhandos.lib.coreui.base.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherDetailsFragment(
    private val launcher: WeatherDetailsLauncher,
) : BaseFragment<WeatherDetailsViewModel, FragmentCurrentWeatherBinding>() {
    override val viewModel: WeatherDetailsViewModel by viewModel {
        parametersOf(launcher)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentCurrentWeatherBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.flowWithLifecycle(lifecycle).onEach(::render).launchIn(lifecycleScope)
        viewModel.getCurrentWeather()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    private fun render(state: ViewState) {
        hideAll()
        when (state) {
            is ViewState.Data<*> -> {
                (state.data as? WeatherDetailsUIState)?.let {
                    viewBinding.dataScreen.isVisible = true
                    dataFetched(it)
                }
            }

            ViewState.Error -> {
                viewBinding.reloadBtn.apply {
                    isVisible = true
                    setOnClickListener {
                        viewModel.getCurrentWeather()
                    }
                }
            }

            ViewState.Loading -> {
                viewBinding.loadingState.isVisible = true
            }
        }
    }

    private fun dataFetched(state: WeatherDetailsUIState) {
        val weatherDvo = state.weatherDvo
        viewBinding.weatherBanner.apply {
            currentTemp = weatherDvo.temp
            description = weatherDvo.status
            feelsLikeTemp = weatherDvo.feelsLike
            currentDataAndTime = weatherDvo.dateAndTime
            location = state.cityDvo.name
        }
        viewBinding.apply {
            state.weatherDvo
            wind.info = weatherDvo.windSpeed
            pressure.info = weatherDvo.pressure
            humidity.info = weatherDvo.humidity
            seaLevel.info = weatherDvo.seaLevel
            sunrise.info = weatherDvo.sunrise
            sunset.info = weatherDvo.sunset
        }
        viewBinding.showList.setOnClickListener {
            viewModel.navigateToWeatherList()
        }
    }

    private fun hideAll() {
        viewBinding.apply {
            loadingState.isVisible = false
            dataScreen.isVisible = false
            reloadBtn.isVisible = false
        }
    }
}