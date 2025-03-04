package ph.org.fmc.fmmp.features.media

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.data.getSampleMediaList
import ph.org.fmc.fmmp.domain.models.MediaInfo
import ph.org.fmc.fmmp.features.common.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.media.components.MediaContentItem
import ph.org.fmc.fmmp.features.media.components.MediaListItem
import ph.org.fmc.fmmp.features.navigation.ScreenDestination

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun MediaScreen() {
    var mediaList by remember { mutableStateOf(emptyList<MediaInfo>()) }

    LaunchedEffect(Unit) {
        mediaList = getSampleMediaList()
    }

    SplitViewLayout(
        items = mediaList,
        itemContent = { mediaInfo, onClick ->
            MediaListItem(
                mediaInfo = mediaInfo,
                onClick = onClick
            )
        },
        detailContent = { mediaInfo, isExpanded, onBackClick, _, _ ->
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