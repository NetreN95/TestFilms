package ru.netren.testfilms.films.main.ui.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import ru.netren.testfilms.films.main.ui.constants.Colors
import ru.netren.testfilms.ui.views.BackIconButton

@Composable
fun FilmDetailsScaffold(
    titleText: String,
    onClickBack: (() -> Unit),
    content: @Composable (PaddingValues) -> Unit
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    BackIconButton(onClickBack = onClickBack)
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = titleText,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                backgroundColor = Colors.scaffoldBackgroundColor,
                contentColor = Colors.scaffoldContentColor
            )
        },
        content = content
    )
}