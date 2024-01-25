package kz.zhandos.features.weather.data.mapper

import kz.zhandos.features.weather.data.model.WeatherListResponse
import kz.zhandos.features.weather.domain.model.WeatherItem
import kz.zhandos.lib.core.Mapper
import java.text.SimpleDateFormat
import java.util.Locale

class WeatherItemDtoMapper : Mapper<WeatherListResponse, List<WeatherItem>> {

    override fun map(from: WeatherListResponse): List<WeatherItem> {
        return buildList<WeatherItem> {
            from.list.forEach { fromItem ->
                add(
                    WeatherItem(
                        tempMin = fromItem.main.tempMin.toInt(),
                        tempMax = fromItem.main.tempMax.toInt(),
                        time = convertDateToMillis(fromItem.dateText),
                        status = fromItem.weather[0].description,
                        temp = fromItem.main.temp.toInt(),
                        tempFeels = fromItem.main.feelsLike.toInt()
                    )
                )
            }
        }
    }

    private fun convertDateToMillis(inputDate: String): Long {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = format.parse(inputDate)
        return date?.time ?: 0
    }
}