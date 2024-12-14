package ru.netren.testfilms.main.multiplatform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import ru.alexgladkov.odyssey.compose.setup.StartScreen
import ru.netren.navigation.odyssey.OdysseyConfiguration
import ru.netren.navigation.odyssey.setNavigationContent
import ru.netren.platform.PlatformAppConfiguration
import ru.netren.testfilms.main.di.initKoin
import ru.netren.testfilms.main.ui.navigation.MainNavigationGraph
import ru.netren.testfilms.main.ui.navigation.mainNavigationGraph

@Composable
fun TestFilmsApp(platformAppConfiguration: PlatformAppConfiguration) {
    var koinIsStarted by rememberSaveable { mutableStateOf(false) }
    if (!koinIsStarted) {
        initKoin(platformAppConfiguration = platformAppConfiguration)
        koinIsStarted = true
    }

    val odysseyConfiguration = OdysseyConfiguration(
        platformAppConfiguration = platformAppConfiguration,
        startScreen = StartScreen.Custom(MainNavigationGraph.Films.name),
    )
    setNavigationContent(
        platformAppConfiguration = platformAppConfiguration,
        odysseyConfiguration = odysseyConfiguration
    ) {
        mainNavigationGraph()
    }
}



