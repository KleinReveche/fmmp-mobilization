package ph.org.fmc.fmmp.domain.models

data class MediaInfo(
    val id: String,
    val title: String,
    val description: String,
    val mediaType: MediaType,
    val thumbnailUrl: String,
    val mediaUrl: String
)

enum class MediaType {
    YOUTUBE
}