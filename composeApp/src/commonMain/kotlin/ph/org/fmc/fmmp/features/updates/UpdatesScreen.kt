package ph.org.fmc.fmmp.features.updates

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.data.getSampleUpdatesList
import ph.org.fmc.fmmp.domain.models.NewsUpdate
import ph.org.fmc.fmmp.features.common.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.navigation.ScreenDestination
import ph.org.fmc.fmmp.features.updates.components.UpdateContentItem
import ph.org.fmc.fmmp.features.updates.components.UpdateListItem
import ph.org.fmc.fmmp.getPlatform

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun UpdatesScreen() {
    var sampleUpdates by remember { mutableStateOf(emptyList<NewsUpdate>()) }

    LaunchedEffect(Unit) {
        sampleUpdates = getSampleUpdatesList()

        // TODO: Remove this if block once the issue is fixed
        // This is a workaround for the issue in https://youtrack.jetbrains.com/issue/CMP-7571
        if (getPlatform().name.startsWith("Web")) {
            sampleUpdates = sampleUpdates.drop(1)
        }

        sampleUpdates = sampleUpdates.sortedByDescending { it.publishedAt }
    }

    SplitViewLayout(
        items = sampleUpdates,
        itemContent = { update, onClick ->
            UpdateListItem(
                newsUpdate = update,
                onClick = onClick
            )
        },
        detailContent = { update, isExpanded, onBackClick, onPreviousClick, onNextClick ->
            UpdateContentItem(
                newsUpdate = update,
                isExpanded = isExpanded,
                onBackClick = onBackClick,
                onPreviousClick = onPreviousClick,
                onNextClick = onNextClick
            )
        }
    )
}

@Serializable
object UpdatesScreenDestination : ScreenDestination