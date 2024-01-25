package kz.zhandos.lib.core.di

import kz.zhandos.lib.core.error.handling.ErrorHandler
import kz.zhandos.lib.core.message.MessageHandler
import org.koin.dsl.module

val coreModule = module {
    single { MessageHandler() }
    single { ErrorHandler(messageHandler = get()) }
}