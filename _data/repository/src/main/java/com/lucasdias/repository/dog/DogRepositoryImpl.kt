package com.lucasdias.repository.dog

import com.lucasdias.core.state.State
import com.lucasdias.data_core.api_call.mapToDomainState
import com.lucasdias.domain.model.breed.Breed
import com.lucasdias.domain.model.search.AnimalType
import com.lucasdias.domain.repository.DogRepository
import com.lucasdias.repository.mapper.toDomain

class DogRepositoryImpl(private val dogApiDataSource: DogApiDataSource) : DogRepository {
    override suspend fun getBreeds(name: String): State<List<Breed>> {
        return dogApiDataSource.getBreeds(name).mapToDomainState {
            State.Success(it.toDomain(AnimalType.DOG))
        }
    }
}
