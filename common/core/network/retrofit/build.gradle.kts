plugins {
    alias(gradlePluginsLibs.plugins.kotlinMultiplatform)
}


kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(networkLibs.retrofit)
                api(networkLibs.retrofit.gson)
                api(networkLibs.retrofit.adapters.result)

                api(projects.common.core.coroutines)
            }
        }
    }
}