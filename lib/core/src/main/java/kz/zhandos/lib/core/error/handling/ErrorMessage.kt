package kz.zhandos.lib.core.error.handling

import kz.zhandos.lib.core.R

val Throwable.errorMessage: Int
    get() = when (this) {
        is ServerException, is DeserializationException -> R.string.error_invalid_response

        is NoServerResponseException -> R.string.error_no_server_response

        is NoInternetException -> R.string.error_no_internet_connection

        is SslHandshakeException -> R.string.error_ssl_handshake

        else -> R.string.error_unexpected
    }