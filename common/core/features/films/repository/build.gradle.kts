plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}


kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.features.films.models)
                api(projects.common.core.coroutines)
            }
        }
    }
}