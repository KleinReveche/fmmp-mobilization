package ph.org.fmc.fmmp.core.ui.platform

import android.content.Intent
import androidx.compose.ui.platform.UriHandler
import androidx.core.net.toUri
import ph.org.fmc.fmmp.core.domain.models.MediaType

actual suspend fun openUri(uri: String, mediaType: MediaType, uriHandler: UriHandler) {
    val intent = when (mediaType) {
        MediaType.YOUTUBE -> Intent(Intent.ACTION_VIEW, uri.toUri()).apply {
            setPackage("com.google.android.youtube")
        }

        MediaType.FACEBOOK -> Intent(Intent.ACTION_VIEW, uri.toUri()).apply {
            setPackage("com.facebook.katana")
        }
    }
    val appContext = AppContext.instance

    if (intent.resolveActivity(appContext.packageManager) != null) {
        appContext.startActivity(intent)
    } else {
        val browserIntent = Intent(Intent.ACTION_VIEW, uri.toUri())
        appContext.startActivity(browserIntent)
    }
}