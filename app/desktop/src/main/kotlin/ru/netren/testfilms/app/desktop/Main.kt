package ru.netren.testfilms.app.desktop

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ru.netren.testfilms.main.jvm.TestFilmsApp

fun main() = application {
    Window(
        title = "Test films app",
        onCloseRequest = ::exitApplication,
        state = WindowState(
            size = DpSize(400.dp, 800.dp)
        ),
        resizable = false
    ) {
        TestFilmsApp(
            onApplicationFinish = { exitApplication() }
        )
    }
}
