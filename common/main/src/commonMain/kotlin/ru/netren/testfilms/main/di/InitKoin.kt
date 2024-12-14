package ru.netren.testfilms.main.di

import androidx.compose.runtime.Composable
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.netren.platform.PlatformAppConfiguration
import ru.netren.testfilms.films.di.getFilmsFeatureModule

@Composable
internal fun initKoin(platformAppConfiguration: PlatformAppConfiguration) {
    val platformModule = module {
        factory<PlatformAppConfiguration> {
            platformAppConfiguration
        }
    }
    val filmsFeatureModule = getFilmsFeatureModule()
    startKoin {
        modules(
            listOf(
                platformModule,
                filmsFeatureModule
            )
        )
    }
}