package com.example.kmpgate

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kmpgate.shared.generated.resources.Res
import kmpgate.shared.generated.resources.app_name
import kmpgate.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        icon = painterResource(Res.drawable.logo),
    ) {
        App()
    }
}