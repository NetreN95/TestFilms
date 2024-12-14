package ru.netren.navigation.odyssey

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.netren.platform.PlatformAppConfiguration

@SuppressLint("ComposableNaming")
@Composable
actual fun setNavigationContent(
    platformAppConfiguration: PlatformAppConfiguration,
    odysseyConfiguration: OdysseyConfiguration,
    navigationGraph: RootComposeBuilder.() -> Unit
) {
    setNavigationContent(
        configuration = odysseyConfiguration,
        navigationGraph = navigationGraph
    )
}