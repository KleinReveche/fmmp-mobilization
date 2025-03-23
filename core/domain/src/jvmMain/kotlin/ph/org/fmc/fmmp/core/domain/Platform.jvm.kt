package ph.org.fmc.fmmp.core.domain

import ph.org.fmc.fmmp.core.domain.models.Platforms

data object DesktopPlatform : Platform {
    override val name: Platforms = determinePlatform()
    override val version: String = System.getProperty("os.version") ?: "Unknown"
}

private fun determinePlatform(): Platforms {
    val osName = System.getProperty("os.name")?.lowercase() ?: return Platforms.Unknown
    return when {
        osName.contains("linux") -> Platforms.Linux
        osName.contains("windows") -> Platforms.Windows
        osName.contains("mac") -> Platforms.macOS
        else -> Platforms.Unknown
    }
}

actual fun getPlatform(): Platform = DesktopPlatform