package ru.netren.testfilms.films.network.retrofit

import retrofit2.http.GET
import ru.netren.network.retrofit.Retrofit
import ru.netren.testfilms.films.network.models.FilmsResponseDTO

internal const val BASE_URL_STT = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask/"

interface FilmsAPI {
    @GET("films.json")
    suspend fun getFilms(): Result<FilmsResponseDTO>
}

fun FilmsAPI(): FilmsAPI {
    return Retrofit(BASE_URL_STT).create(FilmsAPI::class.java)
}
