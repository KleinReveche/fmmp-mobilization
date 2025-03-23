package ph.org.fmc.fmmp.core.domain

import ph.org.fmc.fmmp.core.domain.models.Platforms

interface Platform {
    val name: Platforms
    val version: String
}

expect fun getPlatform(): Platform
