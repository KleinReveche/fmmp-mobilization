package ph.org.fmc.fmmp.core.data

import ph.org.fmc.fmmp.core.domain.models.Platforms

data object WasmJsPlatform : Platform {
    override val name = Platforms.WasmJs
    override val version = "1.0.0"
}

actual fun getPlatform(): Platform = WasmJsPlatform