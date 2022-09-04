package com.lucasdias.breed.view.di

import com.lucasdias.breed.view.list.BreedListAdapter
import com.lucasdias.breed.view_model.model.UIBreed
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val breedViewModule = module {
    factory { (navigate: ((UIBreed) -> Unit)) ->
        BreedListAdapter(navigate)
    }
}
