package ru.netren.testfilms.films.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.views.films.filmdetails.Description
import ru.netren.testfilms.films.ui.views.films.filmdetails.FilmImage
import ru.netren.testfilms.films.ui.views.films.filmdetails.GenresWithYear
import ru.netren.testfilms.films.ui.views.films.filmdetails.LocalizedName
import ru.netren.testfilms.films.ui.views.films.filmdetails.Rating

@Composable
fun FilmDetailsScreen(film: FilmUI) {
    LazyColumn(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        val listOfDetails: List<@Composable () -> Unit> = listOf(
            { FilmImage(film = film) },
            { LocalizedName(film = film) },
            { GenresWithYear(film = film) },
            { Rating(film = film) },
            { Description(film = film) }
        )

        items(listOfDetails.size) {
            listOfDetails[it].invoke()
        }
    }
}