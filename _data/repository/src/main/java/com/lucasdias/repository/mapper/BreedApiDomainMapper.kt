package com.lucasdias.repository.mapper

import com.lucasdias.data.model.api.ApiBreed
import com.lucasdias.domain.model.breed.Breed
import com.lucasdias.domain.model.search.AnimalType
import com.lucasdias.repository.BuildConfig.CAT_IMAGE_URL
import com.lucasdias.repository.BuildConfig.DOG_IMAGE_URL

fun List<ApiBreed>.toDomain(animalType: AnimalType): List<Breed> {
    return map { it.toDomain(animalType) }
}

private fun ApiBreed.toDomain(animalType: AnimalType): Breed {
    return Breed(id, name, temperament, animalType.getImageUrl(imageId), lifetime, wikipediaUrl, energyLevel)
}

private fun AnimalType.getImageUrl(imageId: String?): String {
    return when (this) {
        AnimalType.CAT -> "$CAT_IMAGE_URL$imageId.jpg"
        AnimalType.DOG -> "$DOG_IMAGE_URL$imageId.jpg"
        else -> throw Exception("AnimalType image url not supported")
    }
}
