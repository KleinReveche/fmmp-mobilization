package ph.org.fmc.fmmp.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import ph.org.fmc.fmmp.navigation.TopLevelScreens

@Composable
fun AppBottomNav(
    selectedItem: TopLevelScreens,
    setSelectedItem: (TopLevelScreens) -> Unit
) {
    val items = TopLevelScreens.entries

    val isCompact = with(currentWindowAdaptiveInfo()) {
        windowPosture.isTabletop || windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT
    }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == item) item.selectedIcon else item.unselectedIcon,
                        contentDescription = null
                    )
                },
                label = { Text(item.name) },
                selected = selectedItem == item,
                onClick = { setSelectedItem(item) }
            )
        }
    }
}