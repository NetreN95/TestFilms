package ru.netren.testfilms.films.main.ui.screens

import androidx.compose.runtime.Composable
import ru.netren.testfilms.films.main.ui.scaffold.FilmDetailsScaffold
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.screens.FilmDetailsScreen

@Composable
fun FilmDetailsScreen(
    film: FilmUI,
    onClickBack: (() -> Unit)
) {
    FilmDetailsScaffold(
        titleText = film.name,
        onClickBack = onClickBack
    ) {
        FilmDetailsScreen(film = film)
    }
}
