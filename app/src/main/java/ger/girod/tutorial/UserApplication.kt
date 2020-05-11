package ger.girod.tutorial

import android.app.Application
import ger.girod.tutorial.data.api.apiModule
import ger.girod.tutorial.data.repositories.repoModules
import ger.girod.tutorial.data.utils.internetModule
import ger.girod.tutorial.domain.use_cases.usesCasesModules
import ger.girod.tutorial.ui.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@UserApplication)
            modules(listOf(
                apiModule,
                internetModule,
                usesCasesModules,
                repoModules,
                viewModelModules
            ))
        }
    }
}