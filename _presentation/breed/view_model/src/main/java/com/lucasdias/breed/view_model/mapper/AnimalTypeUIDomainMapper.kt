package com.lucasdias.breed.view_model.mapper

import com.lucasdias.common_model.UIAnimalType
import com.lucasdias.domain.model.search.AnimalType

fun UIAnimalType.toDomain(): AnimalType {
    return AnimalType.valueOf(name)
}
