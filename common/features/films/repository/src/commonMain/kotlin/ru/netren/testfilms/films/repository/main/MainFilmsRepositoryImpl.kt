package ru.netren.testfilms.films.repository.main

import dev.androidbroadcast.RequestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import ru.netren.testfilms.films.models.Film
import ru.netren.testfilms.films.repository.MainFilmsRepository
import ru.netren.testfilms.films.repository.NetworkFilmsRepository

class MainFilmsRepositoryImpl(
    private val networkFilmsRepository: NetworkFilmsRepository
) : MainFilmsRepository {
    override fun getFlowOfFilms(): Flow<RequestResult<List<Film>>> {
        return getFilmsFromServer()
    }

    private fun getFilmsFromServer(): Flow<RequestResult<List<Film>>> {
        val apiRequest = flow { emit(networkFilmsRepository.getFilms()) }
        val start = flowOf<RequestResult<List<Film>>>(RequestResult.InProgress())

        return merge(apiRequest, start)
    }
}