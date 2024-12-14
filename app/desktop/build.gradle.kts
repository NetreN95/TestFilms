import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(gradlePluginsLibs.plugins.kotlinJvm)
    alias(gradlePluginsLibs.plugins.jetbrainsCompose)
    alias(gradlePluginsLibs.plugins.composeCompiler)
}

dependencies {
    implementation(projects.common.main)
    api(projects.common.core.ui.compose)
}

compose.desktop {
    application {
//        mainClass = "ru.netren.testfilms.app.desktop.MainKt"
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Test films app"
            packageVersion = "1.0.0"
        }
    }
}