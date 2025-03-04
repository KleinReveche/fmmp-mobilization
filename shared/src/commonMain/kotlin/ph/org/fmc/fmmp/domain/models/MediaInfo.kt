package ph.org.fmc.fmmp.domain.models

import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.data.FmaParcelable
import ph.org.fmc.fmmp.data.FmaParcelize

@FmaParcelize
@Serializable
data class MediaInfo(
    val id: String,
    val title: String,
    val description: String,
    val mediaType: MediaType,
    val thumbnailUrl: String,
    val mediaUrl: String
) : FmaParcelable