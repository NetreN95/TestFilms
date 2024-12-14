package ru.netren.testfilms.films.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dev.androidbroadcast.models.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.usecases.GetFilmsByGenreUseCase

class FilmsViewModelImpl(
    private val getFilmsByGenreUseCase: GetFilmsByGenreUseCase
) : FilmsViewModel() {
    private val _stateOfFilmsList = MutableStateFlow<State<FilmUI>>(State.None())
    private var _genresList: MutableState<List<String>> = mutableStateOf(listOf())
    private var _currentGenre: MutableState<String> = mutableStateOf("")

    override val stateOfFilmsList: StateFlow<State<FilmUI>>
        get() = _stateOfFilmsList

    override var currentGenre
        get() = _currentGenre.value
        set(genre) {
            setGenre(genre)
        }

    override var genresList: List<String>
        get() = _genresList.value
        set(value) {
            updateGenresList(value)
        }

    init {
        updateFilms()
    }

    override fun onClickUpdateFilms() {
        updateFilms()
    }

    override fun onClickGenre(genre: String) {
        currentGenre = genre
    }

    private fun updateFilms() {
        viewModelScope.launch(Dispatchers.Default) {
            getFilmsByGenreUseCase.execute()
                .collect { state ->
                    _stateOfFilmsList.value = state

                    val tmpGenresList = mutableListOf<String>()

                    state.list?.forEach { film ->
                        film.genres.forEach { genre ->
                            with(genre) {
                                if (!tmpGenresList.contains(this)) {
                                    tmpGenresList.add(this)
                                }
                            }
                        }
                    }

                    genresList = tmpGenresList
                }
        }
    }

    private fun setGenre(genre: String) {
        if (_currentGenre.value != genre) {
            _currentGenre.value = genre
        } else {
            _currentGenre.value = ""
        }
    }

    private fun updateGenresList(genresList: List<String>) {
        if (genresList.isNotEmpty()) {
            _genresList.value = genresList
        }
    }
}