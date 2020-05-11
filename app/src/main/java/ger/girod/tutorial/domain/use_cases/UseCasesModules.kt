package ger.girod.tutorial.domain.use_cases

import org.koin.dsl.module

val usesCasesModules = module {
    factory { provideUsersUseCase(get()) }
}