package kz.zhandos.lib.navigation.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val navigationModule = module {
    single<Cicerone<Router>> { Cicerone.create() }

    single<NavigatorHolder> { get<Cicerone<Router>>().getNavigatorHolder() }

    single<Router> { get<Cicerone<Router>>().router }
}