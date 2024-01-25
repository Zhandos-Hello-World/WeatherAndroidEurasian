package kz.zhandos.lib.coreui.ext

import android.app.AlertDialog
import android.content.Context
import kz.zhandos.lib.core.message.MessageEvent

fun Context.showAlert(messageEvent: MessageEvent) {
    val builder = AlertDialog.Builder(this)

    builder.setTitle(getString(messageEvent.title)).setMessage(getString(messageEvent.description))

    messageEvent.positiveButtonText?.let { text ->
        builder.setPositiveButton(text) { _, _ ->
            messageEvent.positiveButtonAction?.invoke()
        }
    }

    messageEvent.negativeButtonText?.let { text ->
        builder.setNegativeButton(text) { _, _ ->
            messageEvent.negativeButtonAction?.invoke()
        }
    }
    builder.show()
}