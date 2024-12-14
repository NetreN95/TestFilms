package ru.netren.navigation.odyssey

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.StartScreen
import ru.netren.platform.PlatformAppConfiguration

@Composable
actual fun OdysseyConfiguration(
    platformAppConfiguration: PlatformAppConfiguration,
    startScreen: StartScreen,
    backgroundColor: Color
): OdysseyConfiguration {
    return OdysseyConfiguration(
        startScreen = startScreen,
        backgroundColor = backgroundColor
    )
}

@Composable
actual fun OdysseyConfiguration(
    platformAppConfiguration: PlatformAppConfiguration,
    startScreen: StartScreen,
): OdysseyConfiguration {
    return OdysseyConfiguration(
        startScreen = startScreen,
    )
}