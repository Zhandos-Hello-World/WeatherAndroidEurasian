package kz.zhandos.weatherandroid

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel(messageHandler = get()) }
}