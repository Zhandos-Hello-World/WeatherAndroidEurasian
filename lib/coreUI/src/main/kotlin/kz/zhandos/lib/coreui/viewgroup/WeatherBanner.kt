package kz.zhandos.lib.coreui.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kz.zhandos.lib.coreui.databinding.ViewGroupWeatherBannerBinding

class WeatherBanner @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : FrameLayout(
    context,
    attributeSet,
    defStyleAttr,
    defStyleRes,
) {
    private val viewBinding =
        ViewGroupWeatherBannerBinding.inflate(LayoutInflater.from(context), this, true)

    var currentTemp: String = ""
        set(value) {
            field = value
            viewBinding.currentTemp.text = field
        }
    var location: String = ""
        set(value) {
            field = value
            viewBinding.city.text = field
        }

    var currentDataAndTime: String = ""
        set(value) {
            field = value
            viewBinding.dateTime.text = field
        }

    var feelsLikeTemp: String = ""
        set(value) {
            field = value
            viewBinding.feelsLike.text = field
        }

    var description: String = ""
        set(value) {
            field = value
            viewBinding.description.text = field
        }
}