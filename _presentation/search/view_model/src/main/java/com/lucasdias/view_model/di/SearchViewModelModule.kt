package com.lucasdias.view_model.di

import com.lucasdias.view_model.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val searchViewModelModule = module {
    viewModel {
        SearchViewModel()
    }
}
