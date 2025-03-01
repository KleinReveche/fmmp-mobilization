package ph.org.fmc.fmmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform