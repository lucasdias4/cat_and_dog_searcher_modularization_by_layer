package com.lucasdias.breed.view_model.mapper

import com.lucasdias.breed.view_model.model.UIBreed
import com.lucasdias.domain.model.breed.Breed

fun List<Breed>.toUI(): List<UIBreed> {
    return map {
        it.toUI()
    }
}

private fun Breed.toUI(): UIBreed {
    return UIBreed(
        id,
        name,
        temperament,
        imageUrl,
        lifetime,
        wikipediaUrl
    )
}
