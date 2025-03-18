package ph.org.fmc.fmmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ph.org.fmc.fmmp.components.AppBottomNav
import ph.org.fmc.fmmp.core.ui.theme.AppTheme
import ph.org.fmc.fmmp.navigation.FmaNavHost

@Composable
internal fun FmmpMobilization() = AppTheme {
    val appState = rememberAppState()
    val currentTopLevelScreen = appState.currentTopLevelScreen

    Scaffold(
        bottomBar = {
            AppBottomNav(
                selectedItem = currentTopLevelScreen,
                setSelectedItem = { appState.navigateToTopLevelScreen(it) }
            )
        }
    ) {
        Surface(modifier = Modifier.fillMaxSize().padding(it)) {
            FmaNavHost(appState)
        }
    }
}
