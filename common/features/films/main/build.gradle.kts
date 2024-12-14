plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
    alias(gradlePluginsLibs.plugins.composeCompiler)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.features.films.di)
                api(projects.common.core.features.films.ui.navigation)
                implementation(projects.common.core.features.films.ui.screens)
                implementation(projects.common.core.features.films.ui.viewModel)
            }
        }
    }
}