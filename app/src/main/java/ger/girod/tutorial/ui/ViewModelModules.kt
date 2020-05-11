package ger.girod.tutorial.ui

import ger.girod.tutorial.ui.main.MainViewModel
import org.koin.dsl.module

val viewModelModules = module {
    factory { MainViewModel(get()) }
}