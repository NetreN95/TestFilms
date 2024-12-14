package ru.netren.testfilms.films.ui.views.films

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.views.films.filmdetails.FilmImage

@Composable
fun FilmItem(
    film: FilmUI,
    onClickFilm: ((FilmUI) -> Unit)
) {
    Box(
        modifier = Modifier
            .size(
                width = 120.dp,
                height = 360.dp
            )
            .padding(2.dp)
            .clickable {
                onClickFilm.invoke(film)
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            FilmImage(
                film = film,
                showEmptyImage = true
            )

            Text(
                text = film.localizedName,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
