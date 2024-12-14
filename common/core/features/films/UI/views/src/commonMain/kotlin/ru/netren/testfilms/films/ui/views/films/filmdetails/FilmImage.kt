package ru.netren.testfilms.films.ui.views.films.filmdetails

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.views.constants.Strings

@Composable
fun FilmImage(
    film: FilmUI,
    showEmptyImage: Boolean = false
) {
    FilmImage(
        imageUrl = film.imageUrl,
        showEmptyImage = showEmptyImage
    )
}

@Composable
fun FilmImage(
    imageUrl: String,
    showEmptyImage: Boolean = false
) {
    var hasImage by remember {
        mutableStateOf(imageUrl.isNotEmpty())
    }

    if (hasImage) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight(0.85F)
                .fillMaxWidth(),
            model = imageUrl,
            contentDescription = Strings.FILM_IMAGE_CONTENT_DESCRIPTION,
            onState = { state ->
                if (state is AsyncImagePainter.State.Error) {
                    hasImage = false
                }
            }
        )
    } else {
        if (!showEmptyImage) {
            return
        }
        Text(
            modifier = Modifier
                .fillMaxHeight(0.85F)
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            text = Strings.NO_IMAGE_TEXT,
            fontSize = 20.sp
        )
    }
}