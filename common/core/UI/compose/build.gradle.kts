plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
    alias(gradlePluginsLibs.plugins.composeCompiler)
}

android {
    namespace = "ru.netren.core.ui.compose"
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
                api(composeLibs.runtime)
                api(composeLibs.ui)
                api(composeLibs.foundation)
                api(composeLibs.ui.tooling)
                api(composeLibs.ui.tooling.preview)
                api(composeLibs.material)
                api(composeLibs.icons)
            }
        }

        jvmMain {
            dependencies {
                api(composeLibs.desktop.common)
                api(composeLibs.desktop.material)
                api(composeLibs.desktop.windows)
                api(compose.desktop.currentOs)
            }
        }

        androidMain {
            dependencies {
                api(composeLibs.android.activity)
            }
        }
    }
}