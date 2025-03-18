package ph.org.fmc.fmmp.core.ui.platform

import kotlinx.browser.window
import ph.org.fmc.fmmp.core.domain.models.MediaType

actual fun openUri(uri: String, mediaType: MediaType) {
    window.open(uri)
}