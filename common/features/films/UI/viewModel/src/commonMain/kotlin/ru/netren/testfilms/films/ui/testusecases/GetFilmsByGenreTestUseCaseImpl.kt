package ru.netren.testfilms.films.ui.testusecases

import dev.androidbroadcast.RequestResult
import dev.androidbroadcast.mappers.toState
import dev.androidbroadcast.models.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import ru.netren.testfilms.films.ui.models.FilmUI
import ru.netren.testfilms.films.ui.usecases.GetFilmsByGenreUseCase

class GetFilmsByGenreTestUseCaseImpl() : GetFilmsByGenreUseCase {
    override fun execute(): Flow<State<FilmUI>> {
        return getTestFlowOfFilms()
            .map { requestResult ->
                requestResult.toState()
            }
    }
}

internal fun getTestFlowOfFilms(): Flow<RequestResult<List<FilmUI>>> {
    return flowOf(
        RequestResult
            .Success(
                data = getTestListOfFilms()
            )
    )
}