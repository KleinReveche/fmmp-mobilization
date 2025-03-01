package ph.org.fmc.fmmp.features.media

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.data.SampleMedia
import ph.org.fmc.fmmp.features.common.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.media.components.MediaListItem
import ph.org.fmc.fmmp.features.media.components.MediaContentItem
import ph.org.fmc.fmmp.features.navigation.ScreenDestination

@Composable
fun MediaScreen(navigate: (ScreenDestination, Boolean) -> Unit, navigateUp: () -> Unit) {
    SplitViewLayout(
        items = SampleMedia.mediaList,
        itemContent = { mediaInfo, onClick ->
            MediaListItem(
                mediaInfo = mediaInfo,
                onClick = onClick
            )
        },
        detailContent = { mediaInfo, isExpanded, onBackClick ->
            MediaContentItem(
                mediaInfo = mediaInfo,
                isExpanded = isExpanded,
                onBackClick = onBackClick
            )
        }
    )
}

@Serializable
object MediaScreenDestination : ScreenDestination