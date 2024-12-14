plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
}

android {
    namespace = "ru.netren.core.platform"
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
        androidMain {
            dependencies {
                api(androidLibs.androidx.activity)
                api(androidLibs.androidx.activity.ktx)
                api(androidLibs.androidx.appcompat)
            }
        }
    }
}