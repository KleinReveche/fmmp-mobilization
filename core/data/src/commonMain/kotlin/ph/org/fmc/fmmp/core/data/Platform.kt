package ph.org.fmc.fmmp.core.data

import ph.org.fmc.fmmp.core.domain.models.Platforms

interface Platform {
    val name: Platforms
    val version: String
}

expect fun getPlatform(): Platform
