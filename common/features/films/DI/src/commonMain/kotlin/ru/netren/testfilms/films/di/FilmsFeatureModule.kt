package ru.netren.testfilms.films.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.netren.testfilms.films.network.retrofit.FilmsAPI
import ru.netren.testfilms.films.repository.MainFilmsRepository
import ru.netren.testfilms.films.repository.NetworkFilmsRepository
import ru.netren.testfilms.films.repository.main.MainFilmsRepositoryImpl
import ru.netren.testfilms.films.repository.network.NetworkFilmsRepositoryImpl
import ru.netren.testfilms.films.ui.usecases.GetFilmsByGenreUseCase
import ru.netren.testfilms.films.ui.usecases.GetFilmsByGenreUseCaseImpl
import ru.netren.testfilms.films.ui.viewmodel.FilmsViewModel
import ru.netren.testfilms.films.ui.viewmodel.FilmsViewModelImpl

fun getFilmsFeatureModule(): Module {
    return module {
        factory<FilmsAPI> {
            FilmsAPI()
        }

        factory<NetworkFilmsRepository> {
            NetworkFilmsRepositoryImpl(
                filmsAPI = get()
            )
        }

        factory<MainFilmsRepository> {
            MainFilmsRepositoryImpl(
                networkFilmsRepository = get()
            )
        }

        factory<GetFilmsByGenreUseCase> {
            GetFilmsByGenreUseCaseImpl(
                repository = get()
            )
//            GetFilmsByGenreTestUseCaseImpl()
        }

        viewModel<FilmsViewModel> {
            FilmsViewModelImpl(
                getFilmsByGenreUseCase = get()
            )
        }
    }
}
