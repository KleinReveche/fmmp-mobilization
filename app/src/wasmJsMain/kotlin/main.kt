import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import kotlinx.browser.document
import kotlinx.browser.window
import ph.org.fmc.fmmp.FmmpMobilization
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.features.home.HomeScreenDestination
import ph.org.fmc.fmmp.features.media.MediaScreenDestination
import ph.org.fmc.fmmp.features.plans.PlansScreenDestination
import ph.org.fmc.fmmp.features.updates.UpdatesScreenDestination
import ph.org.fmc.fmmp.navigation.TopLevelScreens
import ph.org.fmc.fmmp.rememberAppState

external fun hideLoadingScreen()

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    hideLoadingScreen()
    val body = document.body ?: return
    ComposeViewport(body) {
        val appState = rememberAppState()
        FmmpMobilization(appState)

        var initialDestination: ScreenDestination = HomeScreenDestination

        LaunchedEffect(appState.appLoading) {
            if (appState.appLoading) return@LaunchedEffect
            val initRoute = window.location.hash.substringAfter('#', "")

            when {
                initRoute.startsWith(HomeScreenDestination.serializer().descriptor.serialName) -> {
                    initialDestination = TopLevelScreens.Home.destination
                }

                initRoute.startsWith(PlansScreenDestination.serializer().descriptor.serialName) -> {
                    initialDestination = TopLevelScreens.Plans.destination
                }

                initRoute.startsWith(MediaScreenDestination.serializer().descriptor.serialName) -> {
                    initialDestination = TopLevelScreens.Media.destination
                }

                initRoute.startsWith(UpdatesScreenDestination.serializer().descriptor.serialName) -> {
                    initialDestination = TopLevelScreens.Updates.destination
                }
            }
            appState.navigateToTopLevelScreen(initialDestination)
            window.bindToNavigation(appState.navController)
        }
    }
}
