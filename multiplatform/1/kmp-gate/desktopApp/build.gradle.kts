import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(project(":shared"))

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(libs.compose.uiToolingPreview)

    implementation("org.jetbrains.compose.components:components-resources:1.12.1")
}

compose.desktop {
    application {
        mainClass = "com.example.kmpgate.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Rpm)
            packageName = "com.example.kmpgate"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("src/main/resources/logo.png"))
                menuGroup = "KMP Gate"
            }
        }
    }
}