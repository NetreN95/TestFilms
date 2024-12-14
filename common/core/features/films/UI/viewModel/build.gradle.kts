plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.coroutines)
                api(projects.common.core.ui.viewModel.jetbrains)

                api(projects.common.core.features.films.ui.models)
                implementation(projects.common.core.features.films.models)
            }
        }
    }
}