package ph.org.fmc.fmmp.features.media.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import ph.org.fmc.fmmp.domain.models.MediaInfo
import ph.org.fmc.fmmp.domain.models.MediaType
import ph.org.fmc.fmmp.features.common.components.StickyHeader
import ph.org.fmc.fmmp.features.common.verticalScrollAndDrag
import ph.org.fmc.fmmp.getPlatform
import ph.org.fmc.fmmp.platform.openUri

@Composable
fun MediaContentItem(
    modifier: Modifier = Modifier,
    mediaInfo: MediaInfo,
    isExpanded: Boolean,
    onBackClick: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    var headerPadding by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .verticalScrollAndDrag(
                        scrollState = scrollState,
                        scope = scope
                    )
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(top = if (isExpanded) 0.dp else headerPadding)
            ) {
                val uriHandler = LocalUriHandler.current
                when (mediaInfo.mediaType){
                    MediaType.YOUTUBE -> {
                        MediaCardYoutube(
                            mediaInfo = mediaInfo
                        ) {
                            scope.launch {
                                if (getPlatform().name == "Android") {
                                    openUri(mediaInfo.mediaUrl, MediaType.YOUTUBE)
                                } else {
                                    uriHandler.openUri(mediaInfo.mediaUrl)
                                }
                            }
                        }
                    }
                }
            }

            StickyHeader(
                isExpanded = isExpanded,
                title = null,
                onBackClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh.copy(alpha = 0.95f))
                    .zIndex(1f)
                    .padding(10.dp)
                    .onGloballyPositioned { layoutCoordinates ->
                        headerPadding = layoutCoordinates.size.height.dp + 16.dp
                    }
            )
        }
    }
}