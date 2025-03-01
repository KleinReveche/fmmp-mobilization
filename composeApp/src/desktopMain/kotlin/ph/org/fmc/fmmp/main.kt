package ph.org.fmc.fmmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FMMP Mobilization",
    ) {
        FmmpMobilization()
    }
}