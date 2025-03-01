package ph.org.fmc.fmmp.platform

import kotlinx.browser.window
import ph.org.fmc.fmmp.domain.models.MediaType

actual fun openUri(uri: String, mediaType: MediaType) {
    window.open(uri)
    TODO()
}