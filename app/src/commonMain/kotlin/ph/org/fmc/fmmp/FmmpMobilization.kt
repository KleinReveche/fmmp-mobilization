package ph.org.fmc.fmmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.coroutines.launch
import ph.org.fmc.fmmp.components.AppBottomNav
import ph.org.fmc.fmmp.core.data.getPlatform
import ph.org.fmc.fmmp.core.ui.LocalTopBar
import ph.org.fmc.fmmp.core.ui.theme.AppTheme
import ph.org.fmc.fmmp.features.settings.MainActionsMenu
import ph.org.fmc.fmmp.features.settings.SettingsBottomSheet
import ph.org.fmc.fmmp.features.settings.SettingsData
import ph.org.fmc.fmmp.features.settings.SettingsPopup
import ph.org.fmc.fmmp.navigation.FmaNavHost

@Composable
internal fun FmmpMobilization(appState: FmmpMobilizationAppState = rememberAppState()) = AppTheme {
    val currentTopLevelScreen = appState.selectedTopLevelScreen()
    val buildConfig by remember { mutableStateOf(BuildConfig) }

    Box {
        Scaffold(
            snackbarHost = { SnackbarHost(appState.snackbarState) },
            topBar = LocalTopBar.current.value.topBar,
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

        if (appState.isMainActionsMenuOpen) {
            MainActionsMenu(
                closePopup = { appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen },
                navigateToPrayers = {
                    appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen
                    showFeatureNotAvailable(appState)
                },
                navigateToSettings = {
                    appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen
                    appState.isSettingsMenuOpen = !appState.isSettingsMenuOpen
                },
                navigateToHelp = {
                    showFeatureNotAvailable(appState)
                    appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen
                },
                showSnackbarDebug = {
                    appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen
                    appState.scope.launch {
                        val platform = getPlatform()
                        appState.snackbarState.showSnackbar(
                            message = "Debug mode enabled in ${platform.name} ${platform.version}",
                            actionLabel = "OK"
                        )
                    }
                },
                currentUser = appState.currentUser,
                currentAppVersion = buildConfig.APP_VERSION,
                pgcFacebookPage = Constants.PGC_FB_PAGE,
                fmmpFacebookPage = Constants.FMMP_FB_PAGE
            )
        }

        val settingsData = SettingsData(
            user = appState.currentUser,
            closeSettings = {
                appState.isSettingsMenuOpen = !appState.isSettingsMenuOpen
            },
            navigateToManageAccount = {
                showFeatureNotAvailable(appState)
                appState.isSettingsMenuOpen = !appState.isSettingsMenuOpen
            },
            navigateToTutorialsAndFaqs = {
                showFeatureNotAvailable(appState)
                appState.isSettingsMenuOpen = !appState.isSettingsMenuOpen
            }
        )

        if (appState.isSettingsMenuOpen) {
            if (currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT)
                SettingsBottomSheet(settingsData)
            else
                SettingsPopup(settingsData)
        }
    }
}

private fun showFeatureNotAvailable(appState: FmmpMobilizationAppState) {
    appState.scope.launch {
        appState.snackbarState.showSnackbar(
            message = "Feature not yet available",
            actionLabel = "OK"
        )
    }
}