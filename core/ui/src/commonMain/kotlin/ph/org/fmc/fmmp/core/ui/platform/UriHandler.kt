package ph.org.fmc.fmmp.core.ui.platform

import androidx.compose.ui.platform.UriHandler
import ph.org.fmc.fmmp.core.domain.models.MediaType

expect suspend fun openUri(uri: String, mediaType: MediaType, uriHandler: UriHandler)