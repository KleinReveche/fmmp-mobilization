package ph.org.fmc.fmmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ph.org.fmc.fmmp.FmmpMobilizationAppState
import ph.org.fmc.fmmp.features.home.HomeScreen
import ph.org.fmc.fmmp.features.home.HomeScreenDestination
import ph.org.fmc.fmmp.features.media.MediaScreen
import ph.org.fmc.fmmp.features.media.MediaScreenDestination
import ph.org.fmc.fmmp.features.plans.PlansScreen
import ph.org.fmc.fmmp.features.plans.PlansScreenDestination
import ph.org.fmc.fmmp.features.updates.UpdatesScreen
import ph.org.fmc.fmmp.features.updates.UpdatesScreenDestination

@Composable
fun FmaNavHost(
    appState: FmmpMobilizationAppState
) {
    val navController = appState.navController
    NavHost(navController = navController, startDestination = TopLevelScreens.Home.destination) {
        composable<HomeScreenDestination> {
            HomeScreen {
                appState.isMainActionsMenuOpen = !appState.isMainActionsMenuOpen
            }
        }
        composable<UpdatesScreenDestination> {
            UpdatesScreen()
        }
        composable<PlansScreenDestination> {
            PlansScreen()
        }
        composable<MediaScreenDestination> {
            MediaScreen()
        }
    }

    appState.appLoading = false
}