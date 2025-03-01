package ph.org.fmc.fmmp.platform

import android.content.Intent
import androidx.core.net.toUri
import ph.org.fmc.fmmp.AppContext
import ph.org.fmc.fmmp.domain.models.MediaType

actual fun openUri(uri: String, mediaType: MediaType) {
    val intent = when (mediaType) {
        MediaType.YOUTUBE -> Intent(Intent.ACTION_VIEW, uri.toUri()).apply {
            setPackage("com.google.android.youtube")
        }
        else -> Intent(Intent.ACTION_VIEW, uri.toUri())
    }
    val appContext = AppContext.instance

    if (intent.resolveActivity(appContext.packageManager) != null) {
        appContext.startActivity(intent)
    } else {
        val browserIntent = Intent(Intent.ACTION_VIEW, uri.toUri())
        appContext.startActivity(browserIntent)
    }
}