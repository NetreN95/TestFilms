package ru.netren.testfilms.films.repository.network

import dev.androidbroadcast.RequestResult
import dev.androidbroadcast.map
import dev.androidbroadcast.toRequestResult
import ru.netren.testfilms.films.models.Film
import ru.netren.testfilms.films.network.retrofit.FilmsAPI
import ru.netren.testfilms.films.repository.NetworkFilmsRepository
import ru.netren.testfilms.films.repository.network.mappers.toFilm

class NetworkFilmsRepositoryImpl(private val filmsAPI: FilmsAPI) : NetworkFilmsRepository {
    override suspend fun getFilms(): RequestResult<List<Film>> {
        val apiRequest = filmsAPI.getFilms()
            .toRequestResult()
            .map { response ->
                response.films.map { filmDTO ->
                    filmDTO.toFilm()
                }
            }

        return apiRequest
    }
}