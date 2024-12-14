plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
    alias(gradlePluginsLibs.plugins.androidLibrary)
}

android {
    namespace = "ru.netren.core.coroutines"
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
                api(kotlinLibs.coroutines.core)
            }
        }
        androidMain {
            dependencies {
                api(kotlinLibs.coroutines.android)
            }
        }
        jvmMain {
            dependencies {
                api(kotlinLibs.coroutines.swing)
            }
        }
    }
}