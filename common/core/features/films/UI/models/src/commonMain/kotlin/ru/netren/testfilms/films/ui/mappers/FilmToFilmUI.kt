package ru.netren.testfilms.films.ui.mappers

import ru.netren.testfilms.films.models.Film
import ru.netren.testfilms.films.ui.models.FilmUI

fun Film.toFilmUI(): FilmUI {
    return FilmUI(
        id = this.id,
        localizedName = this.localizedName,
        name = this.name,
        year = this.year,
        rating = this.rating,
        imageUrl = this.imageUrl,
        description = this.description,
        genres = this.genres
    )
}