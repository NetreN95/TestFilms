plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.di.koin)
                api(projects.common.core.features.films.network)
                api(projects.common.core.features.films.repository)
                api(projects.common.core.features.films.ui.viewModel)
            }
        }
    }
}