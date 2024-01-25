package kz.zhandos.lib.coreui.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import kz.zhandos.lib.coreui.R
import kz.zhandos.lib.coreui.databinding.ViewGroupSmallInfoCardBinding

class SmallInfoCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : FrameLayout(
    context,
    attrs,
    defStyleAttr,
    defStyleRes,
) {
    private val binding: ViewGroupSmallInfoCardBinding = ViewGroupSmallInfoCardBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    var title: String = ""
        set(value) {
            field = value
            binding.title.text = field
        }

    var info: String = ""
        set(value) {
            field = value
            binding.subTitle.text = field
        }

    var iconForeground: Int = -1
        set(value) {
            field = value
            if (field != -1) {
                setIconForegroundConfigure(field)
            }
        }


    init {
        context.withStyledAttributes(attrs, R.styleable.SmallInfoCard, defStyleAttr, defStyleRes) {
            title = this.getString(R.styleable.SmallInfoCard_title) ?: ""
            info = this.getString(R.styleable.SmallInfoCard_info) ?: ""
            iconForeground = this.getResourceId(R.styleable.SmallInfoCard_icon, -1)
        }
    }


    private fun setIconForegroundConfigure(resId: Int) {
        binding.iconForeground.setImageDrawable(context.getDrawable(resId))
        binding.iconBackground.visibility = View.VISIBLE
        binding.iconForeground.visibility = View.VISIBLE
        binding.iconImage.visibility = View.GONE
    }
}