package kz.zhandos.features.weather.presentation.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.zhandos.features.weather.databinding.FragmentCitySelectionBinding
import kz.zhandos.features.weather.presentation.city.adapter.AdapterListener
import kz.zhandos.features.weather.presentation.city.adapter.CitySelectionAdapter
import kz.zhandos.features.weather.presentation.model.CityDvo
import kz.zhandos.lib.coreui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitySelectionFragment : BaseFragment<CitySelectionViewModel, FragmentCitySelectionBinding>() {

    override val viewModel: CitySelectionViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentCitySelectionBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CitySelectionAdapter(
            adapterListener = object : AdapterListener<CityDvo> {
                override fun onItemClick(item: CityDvo) {
                    viewModel.navigateToCurrentFragment(item)
                }
            },
        )
        viewBinding.cityRecyclerView.adapter = adapter
        adapter.submitList(viewModel.getCities())
    }
}