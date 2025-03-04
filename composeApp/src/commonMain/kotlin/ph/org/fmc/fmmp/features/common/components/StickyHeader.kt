package ph.org.fmc.fmmp.features.common.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: Remove expect/actual when https://youtrack.jetbrains.com/issue/CMP-7571 is fixed
@Composable
expect fun StickyHeader(
    isExpanded: Boolean,
    title: String?,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
)