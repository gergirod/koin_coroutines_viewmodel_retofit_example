package ger.girod.tutorial.data.api

import org.koin.dsl.module

val apiModule = module {
    factory { provideOkHttpClient() }
    factory { provideUsersApi(get()) }
    single { provideRetrofit(get()) }
}