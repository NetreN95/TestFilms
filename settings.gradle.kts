enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        val dir = "gradle/libs/"

        createLibFromFile("kotlinLibs", "${dir}kotlin.toml")
        createLibFromFile("composeLibs", "${dir}compose.toml")
        createLibFromFile("androidLibs", "${dir}android.toml")
        createLibFromFile("databaseLibs", "${dir}database.toml")
        createLibFromFile("networkLibs", "${dir}network.toml")
        createLibFromFile("navigationLibs", "${dir}navigation.toml")
        createLibFromFile("viewModelLibs", "${dir}viewModel.toml")
        createLibFromFile("diLibs", "${dir}di.toml")
        createLibFromFile("imagesLibs", "${dir}images.toml")
        createLibFromFile("gradlePluginsLibs", "${dir}gradlePlugins.toml")
    }
}



rootProject.name = "TestFilms"

includeProject()

fun includeProject() {
    includeApp()
    includeMain()
    includeFilmsFeature()
    includeCore()
}

fun includeApp() {
    include(":app:desktop")
    include(":app:android")
}

fun includeMain() {
    include(":common:main")
}

fun includeFilmsFeature() {
    include(":common:core:features:films:models")
    include(":common:core:features:films:network")
    include(":common:core:features:films:repository")
    include(":common:core:features:films:DI")
    include(":common:core:features:films:UI:models")
    include(":common:core:features:films:UI:viewModel")
    include(":common:core:features:films:UI:views")
    include(":common:core:features:films:UI:screens")
    include(":common:core:features:films:UI:navigation")

    include(":common:features:films:repository")
    include(":common:features:films:DI")

    include(":common:features:films:UI:viewModel")
    include(":common:features:films:main")
}

fun includeCore() {
    include(":common:core:coroutines")
    include(":common:core:network:retrofit")
    include(":common:core:DI:koin")
    include(":common:core:images:coil")
    include(":common:core:platform")
    include(":common:core:main")

    include(":common:core:UI:compose")
    include(":common:core:UI:viewModel:jetbrains")
    include(":common:core:UI:navigation:odyssey")
}

fun createLibFromFile(libName: String, libPath: String) {
    dependencyResolutionManagement {
        versionCatalogs {
            create(libName) {
                from(files(libPath))
            }
        }
    }
}