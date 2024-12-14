package ru.netren.testfilms.films.main.ui.screens

import androidx.compose.runtime.Composable
import org.koin.compose.getKoin
import ru.alexgladkov.odyssey.compose.setup.StartScreen
import ru.netren.navigation.odyssey.OdysseyConfiguration
import ru.netren.navigation.odyssey.setNavigationContent
import ru.netren.platform.PlatformAppConfiguration
import ru.netren.testfilms.films.main.ui.navigation.filmsNavigationGraph
import ru.netren.testfilms.films.ui.navigation.FilmsNavigationGraph

@Composable
fun FilmsMainScreen() {
    val platformAppConfiguration = getKoin().get<PlatformAppConfiguration>()
    FilmsMainScreen(platformAppConfiguration = platformAppConfiguration)
}

@Composable
fun FilmsMainScreen(platformAppConfiguration: PlatformAppConfiguration) {
    val odysseyConfiguration = OdysseyConfiguration(
        platformAppConfiguration = platformAppConfiguration,
        startScreen = StartScreen.Custom(FilmsNavigationGraph.FilmsList.name),
    )
    setNavigationContent(
        platformAppConfiguration = platformAppConfiguration,
        odysseyConfiguration = odysseyConfiguration
    ) {
        filmsNavigationGraph()
    }
}