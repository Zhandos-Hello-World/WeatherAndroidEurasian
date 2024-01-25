package kz.zhandos.features.weather.presentation.city.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.zhandos.features.weather.databinding.ViewItemCitySelectionBinding
import kz.zhandos.features.weather.presentation.model.CityDvo

class CitySelectionAdapter(private val adapterListener: AdapterListener<CityDvo>) :
    ListAdapter<CityDvo, CitySelectionAdapter.CityViewHolder>(CityCompareDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            binding = ViewItemCitySelectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            adapter = adapterListener,
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CityViewHolder(
        private val binding: ViewItemCitySelectionBinding,
        private val adapter: AdapterListener<CityDvo>,
    ) : ViewHolder(binding.root) {

        fun bind(dvo: CityDvo) {
            binding.name.setOnClickListener { adapter.onItemClick(dvo) }
            binding.name.text = dvo.name
        }
    }

    private class CityCompareDiff : ItemCallback<CityDvo>() {

        override fun areItemsTheSame(oldItem: CityDvo, newItem: CityDvo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CityDvo, newItem: CityDvo): Boolean {
            return oldItem == newItem
        }
    }
}