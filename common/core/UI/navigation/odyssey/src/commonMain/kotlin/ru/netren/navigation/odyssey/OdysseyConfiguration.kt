package ru.netren.navigation.odyssey

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.StartScreen
import ru.netren.platform.PlatformAppConfiguration

@Composable
expect fun OdysseyConfiguration(
    platformAppConfiguration: PlatformAppConfiguration,
    startScreen: StartScreen,
    backgroundColor: Color
): OdysseyConfiguration

@Composable
expect fun OdysseyConfiguration(
    platformAppConfiguration: PlatformAppConfiguration,
    startScreen: StartScreen,
): OdysseyConfiguration