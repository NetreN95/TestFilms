package ru.netren.navigation.odyssey

import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.netren.platform.PlatformAppConfiguration

@Composable
expect fun setNavigationContent(
    platformAppConfiguration: PlatformAppConfiguration,
    odysseyConfiguration: OdysseyConfiguration,
    navigationGraph: RootComposeBuilder.() -> Unit
)