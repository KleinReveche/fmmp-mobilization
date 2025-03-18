package ph.org.fmc.fmmp.features.updates

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.core.data.getSampleUpdatesList
import ph.org.fmc.fmmp.core.domain.models.NewsUpdate
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.core.ui.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.updates.components.UpdateContentItem
import ph.org.fmc.fmmp.features.updates.components.UpdateListItem

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun UpdatesScreen() {
    var sampleUpdates by remember { mutableStateOf(emptyList<NewsUpdate>()) }

    LaunchedEffect(Unit) {
        sampleUpdates = getSampleUpdatesList()
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