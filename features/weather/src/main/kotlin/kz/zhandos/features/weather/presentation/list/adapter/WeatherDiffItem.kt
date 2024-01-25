package kz.zhandos.features.weather.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import kz.zhandos.features.weather.presentation.model.WeatherItemDvo

class WeatherDiffItem : DiffUtil.ItemCallback<WeatherItemDvo>() {

    override fun areItemsTheSame(oldItem: WeatherItemDvo, newItem: WeatherItemDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WeatherItemDvo, newItem: WeatherItemDvo): Boolean {
        return oldItem == newItem
    }
}