package ph.org.fmc.fmmp.core.domain.models

import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.core.domain.Parcelable
import ph.org.fmc.fmmp.core.domain.Parcelize

@Parcelize
@Serializable
data class MediaInfo(
    val id: String,
    val title: String,
    val description: String,
    val mediaType: MediaType,
    val thumbnailUrl: String,
    val mediaUrl: String
) : Parcelable