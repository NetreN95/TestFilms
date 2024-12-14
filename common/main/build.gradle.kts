plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
    alias(gradlePluginsLibs.plugins.composeCompiler)
}

android {
    namespace = "ru.netren.testfilms.main"
    compileSdk = androidLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = androidLibs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvm()
    androidTarget()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.core.main)
                implementation(projects.common.features.films.main)
            }
        }
    }
}