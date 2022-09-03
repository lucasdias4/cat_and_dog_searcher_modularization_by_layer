package com.lucasdias.repository.cat

import com.lucasdias.core.state.State
import com.lucasdias.data_core.api_call.mapToDomainState
import com.lucasdias.domain.model.breed.Breed
import com.lucasdias.domain.model.search.AnimalType
import com.lucasdias.domain.repository.CatRepository
import com.lucasdias.repository.mapper.toDomain

class CatRepositoryImpl(private val catApiDataSource: CatApiDataSource) : CatRepository {
    override suspend fun getBreeds(name: String): State<List<Breed>> {
        return catApiDataSource.getBreeds(name).mapToDomainState {
            State.Success(it.toDomain(AnimalType.CAT))
        }
    }
}
