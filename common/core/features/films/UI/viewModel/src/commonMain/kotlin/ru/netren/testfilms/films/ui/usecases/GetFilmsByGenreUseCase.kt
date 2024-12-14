package ru.netren.testfilms.films.ui.usecases

import dev.androidbroadcast.models.State
import kotlinx.coroutines.flow.Flow
import ru.netren.testfilms.films.ui.models.FilmUI

interface GetFilmsByGenreUseCase {
    fun execute(): Flow<State<FilmUI>>
}