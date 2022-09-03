package com.lucasdias.domain.repository

import com.lucasdias.core.state.State
import com.lucasdias.domain.model.breed.Breed

interface CatRepository {
    suspend fun getBreeds(name: String): State<List<Breed>>
}
