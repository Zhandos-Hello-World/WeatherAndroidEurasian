package kz.zhandos.lib.core.data.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kz.zhandos.lib.core.data.error.ErrorHandlingCallAdapterFactory
import kz.zhandos.lib.core.data.error.ErrorHandlingConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT_SECONDS = 30L
private const val READ_TIMEOUT_SECONDS = 60L
private const val WRITE_TIMEOUT_SECONDS = 60L


@OptIn(ExperimentalSerializationApi::class)
class NetworkApiFactory(
    private val url: String,
    private val apiKey: String,
    private val context: Context
) {
    private val json = createJson()
    private val authorizedOkHttpClient = createOkHttpClient()

    private val authorizedRetrofit = createRetrofit(authorizedOkHttpClient)

    inline fun <reified T : Any> createAuthorizedApi(): T = createAuthorizedApi(T::class.java)

    fun <T : Any> createAuthorizedApi(clazz: Class<T>): T {
        return authorizedRetrofit.create(clazz)
    }

    private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(url).client(okHttpClient)
            .addCallAdapterFactory(ErrorHandlingCallAdapterFactory()).addConverterFactory(
                ErrorHandlingConverterFactory(
                    json.asConverterFactory(
                        "application/json".toMediaType(),
                    ),
                ),
            ).build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)

            addInterceptor(ApiKeyInterceptor(apiKey))
            addInterceptor(ChuckerInterceptor.Builder(context).build())
        }.build()
    }

    private fun createJson(): Json {
        return Json {
            explicitNulls = false
            encodeDefaults = true
            ignoreUnknownKeys = true
            isLenient = true
            prettyPrint = true
        }
    }
}