package kz.zhandos.lib.core.message

import kz.zhandos.lib.core.events.ActionEvent
import java.util.UUID

data class MessageEvent(
    val id: UUID = UUID.randomUUID(),
    val title: Int? = null,
    val description: Int,
    val positiveButtonText: Int? = null,
    val positiveButtonAction: (() -> Unit)? = null,
    val negativeButtonText: Int? = null,
    val negativeButtonAction: (() -> Unit)? = null,
) : ActionEvent