package ru.netren.testfilms.films.ui.views.films.filmdetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.views.constants.Colors

@Composable
fun GenresWithYear(film: FilmUI) {
    GenresWithYear(
        genres = film.genres,
        year = film.year
    )
}

@Composable
fun GenresWithYear(
    genres: List<String>,
    year: Int
) {
    GenresWithYear(
        genres = genres.joinToString(),
        year = year
    )
}

@Composable
fun GenresWithYear(
    genres: String,
    year: Int
) {
    var genresWithYear = ""
    if (genres.isNotEmpty()) {
        genresWithYear = genres
        if (year > 0) {
            genresWithYear += ", $year год"
        }
    } else if (year > 0) {
        genresWithYear = "$year год"
    } else return

    Text(
        text = genresWithYear,
        color = Colors.genresWithYearText
    )
}
