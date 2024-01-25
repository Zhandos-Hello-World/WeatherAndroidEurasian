package kz.zhandos.lib.core.message

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class MessageHandler {
    private val channel = Channel<MessageEvent>(Channel.UNLIMITED)

    val messageFlow = channel.receiveAsFlow()

    fun showMessage(message: MessageEvent) {
        channel.trySend(message)
    }

}