package com.lucasdias.repository.di

import com.lucasdias.domain.repository.CatRepository
import com.lucasdias.domain.repository.DogRepository
import com.lucasdias.repository.cat.CatApiDataSource
import com.lucasdias.repository.cat.CatRepositoryImpl
import com.lucasdias.repository.dog.DogApiDataSource
import com.lucasdias.repository.dog.DogRepositoryImpl
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val repositoryModule = module {
    factory {
        CatRepositoryImpl(
            get<CatApiDataSource>()
        ) as CatRepository
    }

    factory {
        DogRepositoryImpl(
            get<DogApiDataSource>()
        ) as DogRepository
    }
}
