package ru.netren.testfilms.films.ui.viewmodel

import androidx.lifecycle.ViewModel
import dev.androidbroadcast.models.State
import kotlinx.coroutines.flow.StateFlow
import ru.netren.testfilms.films.ui.models.FilmUI

abstract class FilmsViewModel : ViewModel() {
    abstract val stateOfFilmsList: StateFlow<State<FilmUI>>
    abstract var currentGenre: String
    abstract var genresList: List<String>
    abstract fun onClickGenre(genre: String)
    abstract fun onClickUpdateFilms()
}