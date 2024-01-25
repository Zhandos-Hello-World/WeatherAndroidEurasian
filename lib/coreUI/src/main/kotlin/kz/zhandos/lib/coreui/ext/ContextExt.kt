package kz.zhandos.lib.coreui.ext

import android.content.Context
import androidx.annotation.StringRes

fun Context.getString(@StringRes resId: Int?): String {
    return if (resId != null) getString(resId) else ""
}