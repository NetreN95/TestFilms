package ru.netren.testfilms.films.main.ui.screens

import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.netren.testfilms.films.main.ui.constants.Strings
import ru.netren.testfilms.films.main.ui.scaffold.FilmsListScaffold
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.navigation.FilmsNavigationGraph
import ru.netren.testfilms.films.ui.screens.FilmsListScreen
import ru.netren.testfilms.films.ui.viewmodel.FilmsViewModel

@Composable
fun FilmsListScreen() {
    val viewModel = koinViewModel<FilmsViewModel>()

    val rootController = LocalRootController.current
    val onClickFilm = { film: FilmUI ->
        rootController.push(
            screen = FilmsNavigationGraph.FilmDetail.name,
            params = film
        )
    }

    FilmsListScaffold(
        titleText = Strings.FILMS_TEXT
    ) {
        FilmsListScreen(
            viewModel = viewModel,
            onClickFilm = onClickFilm
        )
    }
}
