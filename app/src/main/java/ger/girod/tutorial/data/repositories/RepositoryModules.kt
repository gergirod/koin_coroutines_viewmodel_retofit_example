package ger.girod.tutorial.data.repositories

import org.koin.dsl.module

val repoModules = module {
    factory { UsersRepository(get()) }
}