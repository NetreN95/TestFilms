plugins {
    `kotlin-dsl`

    alias(gradlePluginsLibs.plugins.kotlinMultiplatform) apply false
    alias(gradlePluginsLibs.plugins.jetbrainsCompose) apply false
    alias(gradlePluginsLibs.plugins.composeCompiler) apply false
    alias(gradlePluginsLibs.plugins.androidApplication) apply false
    alias(gradlePluginsLibs.plugins.androidLibrary) apply false
    alias(gradlePluginsLibs.plugins.kotlinJvm) apply false
    alias(gradlePluginsLibs.plugins.sqlDelight) apply false
}

allprojects.onEach { project ->
    project.afterEvaluate {
        with(project.plugins) {
            if (hasPlugin(gradlePluginsLibs.plugins.kotlinMultiplatform.get().pluginId)) {
                task("testClasses")
            }
        }
    }
}