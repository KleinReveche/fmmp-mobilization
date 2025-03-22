package ph.org.fmc.fmmp.features.media

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.core.data.getSampleMediaList
import ph.org.fmc.fmmp.core.domain.models.MediaInfo
import ph.org.fmc.fmmp.core.ui.AppTopBar
import ph.org.fmc.fmmp.core.ui.LocalTopBar
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.core.ui.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.media.components.MediaContentItem
import ph.org.fmc.fmmp.features.media.components.MediaListItem

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun MediaScreen() {
    var mediaList by remember { mutableStateOf(emptyList<MediaInfo>()) }
    var topBar by LocalTopBar.current
    topBar = AppTopBar { }

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
@SerialName("media")
object MediaScreenDestination : ScreenDestination