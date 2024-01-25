package kz.zhandos.lib.core.data.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class ErrorResponse(
    @SerialName("cod")
    val code: Int? = null,
    @SerialName("message")
    val message: String? = null,
)