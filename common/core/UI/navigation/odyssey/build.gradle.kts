plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
    alias(gradlePluginsLibs.plugins.composeCompiler)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
}

android {
    namespace = "ru.netren.core.ui.navigation.odyssey"
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
                api(navigationLibs.odyssey.core)
                api(navigationLibs.odyssey.compose)

                api(projects.common.core.platform)
                api(projects.common.core.ui.compose)
            }
        }

        androidMain {
            dependencies {
//                implementation(navigationLibs.odyssey.android)
            }
        }
    }
}