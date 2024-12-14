plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}


kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(imagesLibs.coil3.compose)
                api(imagesLibs.coil3.network.okhttp)
            }
        }
    }
}