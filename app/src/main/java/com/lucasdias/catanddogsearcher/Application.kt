package com.lucasdias.catanddogsearcher

import android.app.Application
import com.lucasdias.android_core.di.androidCoreModule
import com.lucasdias.catanddogsearcher.di.appModule
import com.lucasdias.data_source.di.apiDataSourceModule
import com.lucasdias.domain.di.domainModule
import com.lucasdias.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Logger

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@Application)
            logger(setupDependencyInjectionLogger())
            modules(
                listOf(
                    apiDataSourceModule,
                    androidCoreModule,
                    appModule,
                    domainModule,
                    repositoryModule
                )
            )
        }
    }

    private fun setupDependencyInjectionLogger(): Logger =
        if (BuildConfig.DEBUG) AndroidLogger() else EmptyLogger()
}
