plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
}

android {
    namespace = "ru.netren.core.di.koin"
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
                api(diLibs.koin.core)
                api(diLibs.koin.core.viewmodel)
                api(diLibs.koin.compose.viewmodel)
                api(diLibs.koin.compose)
            }
        }
        androidMain {
            dependencies {
                api(diLibs.koin.android)
            }
        }
    }
}