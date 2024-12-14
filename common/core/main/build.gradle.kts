plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.platform)
                api(projects.common.core.ui.navigation.odyssey)
                implementation(projects.common.core.features.films.di)
            }
        }
    }
}