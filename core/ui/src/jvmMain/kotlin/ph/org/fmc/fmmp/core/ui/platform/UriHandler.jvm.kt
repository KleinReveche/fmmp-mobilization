package ph.org.fmc.fmmp.core.ui.platform

import androidx.compose.ui.platform.UriHandler
import ph.org.fmc.fmmp.core.domain.models.MediaType

actual suspend fun openUri(uri: String, mediaType: MediaType, uriHandler: UriHandler) {
    uriHandler.openUri(uri)
}