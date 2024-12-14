package ru.netren.testfilms.films.ui.mappers

import ru.netren.testfilms.films.ui.models.FilmUI

fun List<FilmUI>.filteredByGenre(genre: String): List<FilmUI> {
    return this.filter { film ->
        (genre.isEmpty()) || (film.genres.contains(genre))
    }
}