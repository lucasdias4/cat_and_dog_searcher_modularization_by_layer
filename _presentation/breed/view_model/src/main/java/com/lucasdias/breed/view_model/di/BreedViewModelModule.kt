package com.lucasdias.breed.view_model.di

import com.lucasdias.breed.view_model.BreedListViewModel
import com.lucasdias.domain.use_case.GetBreedByNameAndAnimalTypeUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val breedViewModelModule = module {
    viewModel {
        BreedListViewModel(
            get<GetBreedByNameAndAnimalTypeUseCase>()
        )
    }
}
