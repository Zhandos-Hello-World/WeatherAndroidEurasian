package kz.zhandos.features.weather.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.zhandos.features.weather.databinding.FragmentWeatherListBinding
import kz.zhandos.features.weather.presentation.details.WeatherDetailsLauncher
import kz.zhandos.features.weather.presentation.list.adapter.WeatherListAdapter
import kz.zhandos.features.weather.presentation.model.WeatherItemDvo
import kz.zhandos.lib.coreui.base.BaseFragment
import kz.zhandos.lib.coreui.base.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherListFragment(
    private val launcher: WeatherListLauncher,
) : BaseFragment<WeatherListViewModel, FragmentWeatherListBinding>() {
    override val viewModel: WeatherListViewModel by viewModel {
        parametersOf(launcher)
    }
    private var adapter: WeatherListAdapter? = null

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentWeatherListBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WeatherListAdapter()
        viewBinding.data.adapter = adapter

        viewModel.uiState.flowWithLifecycle(lifecycle).onEach(::render).launchIn(lifecycleScope)
    }

    private fun render(state: ViewState) {
        hideAll()
        when (state) {
            is ViewState.Data<*> -> {
                (state.data as? List<*>)?.let { data ->
                    viewBinding.dataScreen.isVisible = true
                    configureDataScreen(data.map { it as WeatherItemDvo })
                }
            }

            ViewState.Error -> {
                viewBinding.reloadBtn.apply {
                    isVisible = true
                    setOnClickListener {
                        viewModel.getWeatherList()
                    }
                }
            }

            ViewState.Loading -> {
                viewBinding.loadingState.isVisible = true
            }
        }
    }

    private fun configureDataScreen(list: List<WeatherItemDvo>) {
        if (list.isNotEmpty()) {
            viewBinding.apply {
                currentTemp.text = list.first().temp
                feelsLike.text = list.first().feelsLike
                back.setOnClickListener {
                    viewModel.backToScreen()
                }
            }
        }

        adapter?.submitList(list)
    }

    private fun hideAll() {
        viewBinding.apply {
            loadingState.isVisible = false
            dataScreen.isVisible = false
            reloadBtn.isVisible = false
        }
    }
}