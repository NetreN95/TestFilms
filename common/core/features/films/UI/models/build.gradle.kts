plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core.features.films.models)
            }
        }
    }
}