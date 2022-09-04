package com.lucasdias.domain.di

import com.lucasdias.domain.repository.CatRepository
import com.lucasdias.domain.repository.DogRepository
import com.lucasdias.domain.use_case.GetBreedByNameAndAnimalTypeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val COROUTINE_DISPATCHER_IO = "COROUTINE_DISPATCHER_IO"
@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val domainModule = module {
    factory {
        GetBreedByNameAndAnimalTypeUseCase(
            get<CatRepository>(),
            get<DogRepository>(),
            get<CoroutineDispatcher>(named(COROUTINE_DISPATCHER_IO))
        )
    }

    factory(named(COROUTINE_DISPATCHER_IO)) {
        Dispatchers.IO
    }
}
