package ru.netren.testfilms.films.ui.views.films.filmdetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.netren.testfilms.films.ui.models.FilmUI

@Composable
fun LocalizedName(film: FilmUI) {
    LocalizedName(localizedName = film.localizedName)
}

@Composable
fun LocalizedName(localizedName: String) {
    Text(
        text = localizedName,
        fontSize = 26.sp,
        fontWeight = FontWeight.Black
    )
}