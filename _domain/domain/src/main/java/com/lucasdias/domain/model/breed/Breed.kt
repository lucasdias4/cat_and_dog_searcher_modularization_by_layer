package com.lucasdias.domain.model.breed

data class Breed(
    val id: String,
    val name: String,
    val temperament: String?,
    val imageUrl: String,
    val lifetime: String?,
    val wikipediaUrl: String?
)
