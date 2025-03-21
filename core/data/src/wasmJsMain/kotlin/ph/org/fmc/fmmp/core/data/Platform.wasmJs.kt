package ph.org.fmc.fmmp.core.data

import kotlinx.browser.window
import ph.org.fmc.fmmp.core.domain.models.Platforms

data object WasmJsPlatform : Platform {
    override val name = Platforms.WasmJs
    override val version = window.navigator.appVersion
}

actual fun getPlatform(): Platform = WasmJsPlatform