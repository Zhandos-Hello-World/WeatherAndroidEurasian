package kz.zhandos.lib.core.data.error

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kz.zhandos.lib.core.error.handling.DeserializationException
import retrofit2.HttpException
import java.nio.charset.Charset

internal fun HttpException.getErrorResponse(): ErrorResponse? {
    return try {
        val errorMessage =
            this.response()?.errorBody()?.source()?.readString(Charset.defaultCharset()).orEmpty()
        Json.decodeFromString(errorMessage)
    } catch (e: SerializationException) {
        throw DeserializationException(e)
    }
}