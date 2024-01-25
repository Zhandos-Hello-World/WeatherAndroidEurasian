package kz.zhandos.weatherandroid

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.zhandos.lib.core.message.MessageHandler
import kz.zhandos.lib.coreui.base.BaseViewModel

class MainViewModel(
    private val messageHandler: MessageHandler,
) : BaseViewModel() {

    fun collectMessage() {
        viewModelScope.launch {
            messageHandler.messageFlow.collect { messageEvent ->
                notifyEvent(
                    messageEvent
                )
            }
        }
    }
}