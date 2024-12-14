package ru.netren.testfilms.films.ui.views.films.filmdetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import ru.netren.testfilms.films.ui.models.FilmUI

@Composable
fun Description(film: FilmUI) {
    Description(description = film.description)
}

@Composable
fun Description(description: String) {
    Text(
        text = description,
        fontSize = 16.sp
    )
}