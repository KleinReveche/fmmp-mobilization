package ph.org.fmc.fmmp.features.common.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun <T> SplitViewLayout(
    navigator: ThreePaneScaffoldNavigator<T> = rememberListDetailPaneScaffoldNavigator<T>(),
    items: List<T>,
    topPadding: Boolean = true,
    horizontalPadding: Boolean = true,
    itemContent: @Composable (item: T, onClick: (T) -> Unit) -> Unit,
    detailContent: @Composable (
        item: T,
        isExpanded: Boolean,
        onBackClick: () -> Unit,
        onPreviousClick: () -> Unit,
        onNextClick: () -> Unit
    ) -> Unit
) {
    val scope = rememberCoroutineScope()
    val isExpanded = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = if (topPadding) 10.dp else 0.dp,
                start = if (horizontalPadding) 10.dp else 0.dp,
                end = if (horizontalPadding) 10.dp else 0.dp,
                bottom = if (horizontalPadding) 10.dp else 0.dp
            )
    ) {
        if (isExpanded) {
            LaunchedEffect(Unit) {
                if (items.isNotEmpty()) navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, items.first())
            }
        }

        ListDetailPaneScaffold(
            directive = navigator.scaffoldDirective,
            value = navigator.scaffoldValue,
            listPane = {
                AnimatedPane {
                    LazyColumn {
                        items(items.size) { index ->
                            val item = items[index]
                            itemContent(item) {
                                scope.launch {
                                    navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, item)
                                }
                            }
                        }
                    }
                }
            },
            detailPane = {
                AnimatedPane {
                    navigator.currentDestination?.contentKey?.let { item ->
                        detailContent(
                            item,
                            isExpanded,
                            {
                                scope.launch {
                                    navigator.navigateTo(ListDetailPaneScaffoldRole.List)
                                }
                            },
                            {
                                val index = items.indexOf(item)
                                if (index > 0) {
                                    scope.launch {
                                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, items[index - 1])
                                    }
                                }
                            },
                            {
                                val index = items.indexOf(item)
                                if (index < items.size - 1) {
                                    scope.launch {
                                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, items[index + 1])
                                    }
                                }
                            }
                        )
                    }
                }
            }
        )
    }
}