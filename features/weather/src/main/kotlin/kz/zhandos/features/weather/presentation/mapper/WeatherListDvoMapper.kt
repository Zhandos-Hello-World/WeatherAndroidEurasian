package kz.zhandos.features.weather.presentation.mapper

import kz.zhandos.features.weather.domain.model.WeatherItem
import kz.zhandos.features.weather.presentation.model.WeatherItemDvo
import kz.zhandos.lib.core.Mapper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherListDvoMapper : Mapper<List<WeatherItem>, List<WeatherItemDvo>> {

    override fun map(from: List<WeatherItem>): List<WeatherItemDvo> {
        return buildList {
            from.forEach { fromItem ->
                add(
                    WeatherItemDvo(
                        id = fromItem.time,
                        tempMin = "${fromItem.tempMin}°",
                        tempMax = "${fromItem.tempMax}°",
                        time = formatDateFromMillis(fromItem.time),
                        status = fromItem.status,
                        temp = "${fromItem.temp}°",
                        feelsLike = "Feels like ${fromItem.tempFeels}°",
                    )
                )
            }
        }
    }

    private fun formatDateFromMillis(millis: Long): String {
        val date = Date(millis)
        val formatter = SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault())
        return formatter.format(date)
    }
}