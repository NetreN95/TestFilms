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
                api(projects.common.core.ui.compose)

                implementation(projects.common.core.features.films.ui.models)
                implementation(projects.common.core.features.films.ui.viewModel)
                implementation(projects.common.core.features.films.ui.views)
            }
        }
    }
}