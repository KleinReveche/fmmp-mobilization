package ph.org.fmc.fmmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

external fun onLoadFinished()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onLoadFinished()
    ComposeViewport(document.body!!) {
        FmmpMobilization()
    }
}