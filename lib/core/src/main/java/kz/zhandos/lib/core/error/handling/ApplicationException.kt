package kz.zhandos.lib.core.error.handling

open class ApplicationException(cause: Throwable?) : Exception(cause)

class InvalidAPIKEYException(cause: Throwable?) : ApplicationException(cause)

class ServerException(cause: Throwable?) : ApplicationException(cause)

class NoInternetException(cause: Throwable?) : ApplicationException(cause)

class NoServerResponseException(cause: Throwable?) : ApplicationException(cause)

class DeserializationException(cause: Throwable?) : ApplicationException(cause)

class SslHandshakeException(cause: Throwable?) : ApplicationException(cause)

class UnknownException(cause: Throwable?) : ApplicationException(cause)