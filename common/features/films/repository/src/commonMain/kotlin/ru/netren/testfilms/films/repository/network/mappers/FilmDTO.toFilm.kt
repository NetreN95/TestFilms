package ru.netren.testfilms.films.repository.network.mappers

import ru.netren.testfilms.films.models.Film
import ru.netren.testfilms.films.network.models.FilmDTO

internal fun FilmDTO.toFilm(): Film {
    return Film(
        id = this.id,
        localizedName = this.localizedName,
        name = this.name,
        year = this.year,
        rating = this.rating,
        imageUrl = this.imageUrl ?: "",
        description = this.description ?: "",
        genres = this.genres.map { genre ->
            genre.replacedFirstCharToUpperCase()
        }
    )
}
