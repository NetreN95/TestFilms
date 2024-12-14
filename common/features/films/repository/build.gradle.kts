plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.features.films.repository)
                implementation(projects.common.core.features.films.network)
            }
        }
    }
}