plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.features.films.ui.viewModel)
                implementation(projects.common.features.films.repository)
            }
        }
    }
}