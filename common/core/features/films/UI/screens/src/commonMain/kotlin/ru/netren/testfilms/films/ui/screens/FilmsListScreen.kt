package ru.netren.testfilms.films.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.androidbroadcast.models.State
import ru.netren.testfilms.films.ui.mappers.filteredByGenre
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.screens.constants.Strings
import ru.netren.testfilms.films.ui.viewmodel.FilmsViewModel
import ru.netren.testfilms.films.ui.views.films.FilmItem
import ru.netren.testfilms.films.ui.views.genres.GenreItem
import ru.netren.testfilms.ui.screens.LoadingScreen
import ru.netren.testfilms.ui.screens.NetworkErrorScreen

@Composable
fun FilmsListScreen(
    viewModel: FilmsViewModel,
    onClickFilm: ((film: FilmUI) -> Unit),
    onClickGenre: ((genre: String) -> Unit) = { viewModel.onClickGenre(genre = it) }
) {
    val stateOfFilmsList by viewModel.stateOfFilmsList.collectAsState()

    when (stateOfFilmsList) {
        is State.Success -> {
            FilmsListScreen(
                filmsList = (stateOfFilmsList as State.Success).list
                    .filteredByGenre(genre = viewModel.currentGenre)
                    .sortedBy { it.localizedName },
                genresList = viewModel.genresList,
                currentGenre = viewModel.currentGenre,
                onClickGenre = onClickGenre,
                onClickFilm = onClickFilm
            )
        }

        is State.Error -> {
            NetworkErrorScreen(
                onClickTryAgain = { viewModel.onClickUpdateFilms() }
            )
        }

        is State.Loading -> {
            LoadingScreen()
        }

        is State.None -> {}
    }
}

@Composable
fun FilmsListScreen(
    filmsList: List<FilmUI>,
    genresList: List<String>,
    currentGenre: String,
    onClickGenre: ((genre: String) -> Unit),
    onClickFilm: ((film: FilmUI) -> Unit),
    columns: Int = 2
) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(10.dp),
        columns = GridCells.Fixed(count = columns)
    ) {
        item(span = { GridItemSpan(currentLineSpan = columns) }) {
            Text(
                text = Strings.GENRES_TEXT,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
        }
        items(
            genresList.size,
            span = { GridItemSpan(currentLineSpan = columns) }
        ) { index ->
            GenreItem(
                genre = genresList[index],
                currentGenre = currentGenre,
                onClickGenre = onClickGenre
            )
        }

        item(span = { GridItemSpan(currentLineSpan = columns) }) {
            Text(
                text = Strings.FILMS_TEXT,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
        }
        items(
            count = filmsList.size,
            key = { index ->
                filmsList[index].id
            }
        ) { index ->
            FilmItem(
                film = filmsList[index],
                onClickFilm = onClickFilm
            )
        }
    }
}