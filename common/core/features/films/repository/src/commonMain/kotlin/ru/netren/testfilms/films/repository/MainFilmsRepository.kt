package ru.netren.testfilms.films.repository

import dev.androidbroadcast.RequestResult
import kotlinx.coroutines.flow.Flow
import ru.netren.testfilms.films.models.Film

interface MainFilmsRepository {
    fun getFlowOfFilms(): Flow<RequestResult<List<Film>>>
}