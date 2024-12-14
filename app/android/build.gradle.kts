plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidApplication)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
    alias(gradlePluginsLibs.plugins.composeCompiler)
}

android {
    namespace = "ru.netren.testfilms.app.android"
    compileSdk = androidLibs.versions.compileSdk.get().toInt()


    defaultConfig {
        applicationId = "ru.netren.testfilms"
        minSdk = androidLibs.versions.minSdk.get().toInt()
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
}

kotlin {
    androidTarget()
    sourceSets {
        androidMain {
            dependencies {
                implementation(projects.common.main)

                api(projects.common.core.ui.compose)
                api(projects.common.core.platform)
            }
        }
    }
}