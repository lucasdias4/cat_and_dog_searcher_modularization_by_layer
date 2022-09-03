package com.lucasdias.domain.di

import com.lucasdias.domain.repository.CatRepository
import com.lucasdias.domain.repository.DogRepository
import com.lucasdias.domain.use_case.GetBreedByNameAndAnimalTypeUseCase
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val domainModule = module {
    factory {
        GetBreedByNameAndAnimalTypeUseCase(
            get<CatRepository>(),
            get<DogRepository>(),
        )
    }
}
