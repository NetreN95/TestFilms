package ru.netren.testfilms.main.android

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import ru.netren.platform.PlatformAppConfiguration
import ru.netren.testfilms.main.multiplatform.TestFilmsApp

@Composable
fun TestFilmsApp(androidContext: ComponentActivity) {
    TestFilmsApp(
        platformAppConfiguration = PlatformAppConfiguration(
            androidContext = androidContext
        )
    )
}