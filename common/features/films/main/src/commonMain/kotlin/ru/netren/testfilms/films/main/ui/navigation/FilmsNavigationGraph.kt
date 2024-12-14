package ru.netren.testfilms.films.main.ui.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.netren.testfilms.films.main.ui.screens.FilmDetailsScreen
import ru.netren.testfilms.films.main.ui.screens.FilmsListScreen
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.navigation.FilmsNavigationGraph

internal fun RootComposeBuilder.filmsNavigationGraph() {
    screen(FilmsNavigationGraph.FilmsList.name) {
        FilmsListScreen()
    }
    screen(FilmsNavigationGraph.FilmDetail.name) {
        val film = (it as FilmUI)
        val currentController = LocalRootController.current

        FilmDetailsScreen(
            film = film,
            onClickBack = {
                currentController.popBackStack()
            }
        )
    }
}