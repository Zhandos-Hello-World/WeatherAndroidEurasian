package kz.zhandos.lib.core.error.handling

import kz.zhandos.lib.core.R
import kz.zhandos.lib.core.message.MessageEvent
import kz.zhandos.lib.core.message.MessageHandler

class ErrorHandler(
    private val messageHandler: MessageHandler,
) {

    fun handleError(throwable: Throwable, showError: Boolean = true) {
        throwable.printStackTrace()
        when {
            showError -> {
                messageHandler.showMessage(
                    MessageEvent(
                        title = R.string.error_title,
                        description = throwable.errorMessage,
                        positiveButtonText = R.string.ok,
                    ),
                )
            }
        }
    }
}