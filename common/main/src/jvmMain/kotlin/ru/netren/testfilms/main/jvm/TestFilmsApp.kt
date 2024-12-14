package ru.netren.testfilms.main.jvm

import androidx.compose.runtime.Composable
import ru.netren.platform.PlatformAppConfiguration
import ru.netren.testfilms.main.multiplatform.TestFilmsApp

@Composable
fun TestFilmsApp(onApplicationFinish: () -> Unit) {
    TestFilmsApp(
        platformAppConfiguration = PlatformAppConfiguration(
            onApplicationFinish = onApplicationFinish
        )
    )
}