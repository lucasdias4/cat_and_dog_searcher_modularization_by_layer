package com.lucasdias.domain.use_case

import com.lucasdias.core.state.State
import com.lucasdias.core.state.merge
import com.lucasdias.domain.model.breed.Breed
import com.lucasdias.domain.model.search.AnimalType
import com.lucasdias.domain.repository.CatRepository
import com.lucasdias.domain.repository.DogRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class GetBreedByNameAndAnimalTypeUseCase(
    private val catRepository: CatRepository,
    private val dogRepository: DogRepository
) {
    suspend operator fun invoke(name: String, requestType: AnimalType): State<List<Breed>> {
        return when (requestType) {
            AnimalType.CAT -> catRepository.getBreeds(name)
            AnimalType.DOG -> dogRepository.getBreeds(name)
            else -> getCatAndDogBreeds(name)
        }
    }

    private suspend fun getCatAndDogBreeds(name: String): State<List<Breed>> = coroutineScope {
        val states = awaitAll(
            async { catRepository.getBreeds(name) },
            async { dogRepository.getBreeds(name) }
        )
        return@coroutineScope states.merge()
    }
}