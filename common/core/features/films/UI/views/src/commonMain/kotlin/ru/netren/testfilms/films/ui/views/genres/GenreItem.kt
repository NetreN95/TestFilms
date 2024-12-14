package ru.netren.testfilms.films.ui.views.genres

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import ru.netren.testfilms.films.ui.views.constants.Colors

@Composable
fun GenreItem(
    genre: String,
    currentGenre: String,
    onClickGenre: ((String) -> Unit)
) {
    val boxModifier =
        if (genre != currentGenre) {
            Modifier
        } else {
            Modifier.background(color = Colors.chosenGenreBackground)
        }
            .fillMaxWidth()
            .clickable {
                onClickGenre.invoke(genre)
            }

    Box(
        modifier = boxModifier
    ) {
        Text(
            text = genre,
            fontSize = 20.sp
        )
    }
}