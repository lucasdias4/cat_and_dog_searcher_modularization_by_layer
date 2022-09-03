package com.lucasdias.breed.view_model.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIBreed(
    val id: String,
    val name: String,
    val temperament: String?,
    val imageUrl: String,
    val lifetime: String?,
    val wikipediaUrl: String?
) : Parcelable
