package kz.zhandos.features.weather.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.zhandos.features.weather.databinding.ItemWeatherBinding
import kz.zhandos.features.weather.presentation.model.WeatherItemDvo

class WeatherListAdapter :
    ListAdapter<WeatherItemDvo, WeatherListAdapter.WeatherItemViewHolder>(WeatherDiffItem()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemViewHolder {
        return WeatherItemViewHolder(
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class WeatherItemViewHolder(private val binding: ItemWeatherBinding) :
        ViewHolder(binding.root) {

        fun bind(weatherItemDvo: WeatherItemDvo) {
            binding.apply {
                date.text = weatherItemDvo.time
                status.text = weatherItemDvo.status
                maxTemp.text = weatherItemDvo.tempMax
                minTemp.text = weatherItemDvo.tempMin
            }
        }
    }
}