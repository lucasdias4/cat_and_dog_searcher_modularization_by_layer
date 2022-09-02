package com.lucasdias.android_core.di

import com.lucasdias.android_core.connectivity.Connectivity
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val androidCoreModule = module {
    single {
        Connectivity(androidContext())
    }
}
