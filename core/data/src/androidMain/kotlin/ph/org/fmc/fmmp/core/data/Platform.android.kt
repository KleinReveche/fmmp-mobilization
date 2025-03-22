package ph.org.fmc.fmmp.core.data

import android.os.Build
import ph.org.fmc.fmmp.core.domain.models.Platforms

data object AndroidPlatform : Platform {
    override val name = Platforms.Android
    override val version: String = "${Build.VERSION.RELEASE} (${Build.VERSION.SDK_INT})"
}

actual fun getPlatform(): Platform = AndroidPlatform