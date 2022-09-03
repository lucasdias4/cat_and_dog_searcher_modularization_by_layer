package com.lucasdias.breed.view.di

import com.lucasdias.breed.view.list.BreedListAdapter
import com.lucasdias.breed.view_model.model.UIBreed
import org.koin.dsl.module

const val CHARACTER_ADAPTER = "CHARACTER_ADAPTER"
const val PRICE_ADAPTER = "PRICE_ADAPTER"
const val STORY_ADAPTER = "STORY_ADAPTER"
const val CREATOR_ADAPTER = "CREATOR_ADAPTER"

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val breedViewModule = module {

    factory { (navigate: ((UIBreed) -> Unit)) ->
        BreedListAdapter(navigate)
    }
}
