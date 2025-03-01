package ph.org.fmc.fmmp.features.updates

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.data.SampleUpdates.sampleUpdates
import ph.org.fmc.fmmp.features.common.layout.SplitViewLayout
import ph.org.fmc.fmmp.features.navigation.ScreenDestination
import ph.org.fmc.fmmp.features.updates.components.UpdateContentItem
import ph.org.fmc.fmmp.features.updates.components.UpdateListItem

@Composable
fun UpdatesScreen(
    navigate: (screen: ScreenDestination, isTopLevel: Boolean) -> Unit, navigateUp: () -> Unit
) {
    SplitViewLayout(
        items = sampleUpdates,
        itemContent = { update, onClick ->
            UpdateListItem(
                newsUpdate = update,
                onClick = onClick
            )
        },
        detailContent = { update, isExpanded, onBackClick ->
            UpdateContentItem(
                newsUpdate = update,
                isExpanded = isExpanded,
                onBackClick = onBackClick
            )
        }
    )
}

@Serializable
object UpdatesScreenDestination : ScreenDestination