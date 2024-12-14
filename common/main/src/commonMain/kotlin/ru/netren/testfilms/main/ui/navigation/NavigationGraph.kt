package ru.netren.testfilms.main.ui.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.netren.testfilms.films.main.ui.screens.FilmsMainScreen

internal fun RootComposeBuilder.mainNavigationGraph() {
    screen(MainNavigationGraph.Films.name) {
        FilmsMainScreen()
    }
}