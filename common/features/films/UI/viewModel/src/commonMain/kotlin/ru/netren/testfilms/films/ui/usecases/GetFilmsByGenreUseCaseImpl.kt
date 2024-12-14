package ru.netren.testfilms.films.ui.usecases

import dev.androidbroadcast.RequestResult
import dev.androidbroadcast.map
import dev.androidbroadcast.mappers.toState
import dev.androidbroadcast.models.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.netren.testfilms.films.repository.MainFilmsRepository
import ru.netren.testfilms.films.ui.mappers.toFilmUI
import ru.netren.testfilms.films.ui.models.FilmUI

class GetFilmsByGenreUseCaseImpl(
    private val repository: MainFilmsRepository
) : GetFilmsByGenreUseCase {
    override fun execute(): Flow<State<FilmUI>> {
        return getFlowOfFilmsFromRepository()
            .map { requestResult ->
                requestResult.toState()
            }
    }

    private fun getFlowOfFilmsFromRepository(): Flow<RequestResult<List<FilmUI>>> {
        return repository.getFlowOfFilms()
            .map { requestResult ->
                requestResult.map { films ->
                    films.map { film ->
                        film.toFilmUI()
                    }
                }
            }
    }
}
