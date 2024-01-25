package kz.zhandos.lib.core.data.di

import kz.zhandos.lib.core.data.network.NetworkApiFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun coreDataModule(backendUrl: String, apiKey: String) = module {
    single {
        NetworkApiFactory(
            url = backendUrl,
            apiKey = apiKey,
            context = androidContext(),
        )
    }
}