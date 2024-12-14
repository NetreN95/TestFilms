package ru.netren.testfilms.films.ui.views.films.filmdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.views.constants.Colors
import ru.netren.testfilms.films.ui.views.constants.Strings

@Composable
fun Rating(film: FilmUI) {
    Rating(rating = film.rating)
}

@Composable
fun Rating(rating: Double) {
    if (rating <= 0) {
        return
    }
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = String.format("%.1f", rating),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Colors.ratingText
        )
        Text(
            text = Strings.KINOPOISK,
            fontSize = 18.sp,
            color = Colors.ratingText
        )
    }
}