plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.ui.navigation.odyssey)
            }
        }
    }
}