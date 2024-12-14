package ru.netren.testfilms.films.models

data class Film(
    val id: Int,
    val localizedName: String,
    val name: String,
    val year: Int,
    val rating: Double,
    val imageUrl: String,
    val description: String,
    val genres: List<String>
)
