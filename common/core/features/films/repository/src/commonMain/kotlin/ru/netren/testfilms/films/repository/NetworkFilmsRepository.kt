package ru.netren.testfilms.films.repository

import dev.androidbroadcast.RequestResult
import ru.netren.testfilms.films.models.Film

interface NetworkFilmsRepository {
    suspend fun getFilms(): RequestResult<List<Film>>
}