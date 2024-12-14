package ru.netren.testfilms.films.network.models

import com.google.gson.annotations.SerializedName

data class FilmsResponseDTO(
    @SerializedName("films")
    val films: List<FilmDTO>
)
