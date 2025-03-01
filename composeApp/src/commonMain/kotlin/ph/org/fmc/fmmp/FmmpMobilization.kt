package ph.org.fmc.fmmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ph.org.fmc.fmmp.features.common.components.AppBottomNav
import ph.org.fmc.fmmp.features.common.theme.FmmpMobilizationTheme
import ph.org.fmc.fmmp.features.navigation.FmaNavHost

@Composable
@Preview
fun FmmpMobilization() {
    val appState = rememberAppState()
    val currentTopLevelScreen = appState.currentTopLevelScreen

    FmmpMobilizationTheme {
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
}