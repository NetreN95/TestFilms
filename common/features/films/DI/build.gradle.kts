plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}


kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.features.films.di)

                implementation(projects.common.features.films.repository)
                implementation(projects.common.features.films.ui.viewModel)
            }
        }
    }
}