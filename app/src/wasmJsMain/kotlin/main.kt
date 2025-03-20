import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import ph.org.fmc.fmmp.FmmpMobilization

external fun hideLoadingScreen()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    hideLoadingScreen()
    val body = document.body ?: return
    ComposeViewport(body) {
        FmmpMobilization()
    }
}
