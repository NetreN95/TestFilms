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
                implementation(projects.common.core.features.films.ui.models)
                api(projects.common.core.ui.compose)
                api(projects.common.core.images.coil)
            }
        }
    }
}