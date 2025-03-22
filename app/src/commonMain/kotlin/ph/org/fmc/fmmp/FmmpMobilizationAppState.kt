package ph.org.fmc.fmmp

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import ph.org.fmc.fmmp.core.domain.models.User
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.features.home.HomeScreenDestination
import ph.org.fmc.fmmp.features.media.MediaScreenDestination
import ph.org.fmc.fmmp.features.plans.PlansScreenDestination
import ph.org.fmc.fmmp.features.updates.UpdatesScreenDestination
import ph.org.fmc.fmmp.navigation.TopLevelScreens

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): FmmpMobilizationAppState {
    return remember(
        navController, coroutineScope, snackbarHostState
    ) {
        FmmpMobilizationAppState(
            navController = navController, scope = coroutineScope, snackbarState = snackbarHostState
        )
    }
}

@Stable
class FmmpMobilizationAppState(
    val navController: NavHostController,
    val scope: CoroutineScope,
    val snackbarState: SnackbarHostState
) {
    var appLoading by mutableStateOf(true)
    val topLevelScreens = TopLevelScreens.entries
    var isMainActionsMenuOpen by mutableStateOf(false)
    var isSettingsMenuOpen by mutableStateOf(false)
    var currentUser by mutableStateOf(
        User(
            name = "Juan Dela Cruz",
            email = "juandelacruz@gmail.com",
            profilePictureUrl = "https://randomuser.me/api/portraits/lego/5.jpg"
        )
    )

    fun navigateUp() {
        val currentDestination = navController.currentBackStackEntry
        if (topLevelScreens.any { it.destination::class.qualifiedName == currentDestination?.destination?.route }) {
            navigateToTopLevelScreen(TopLevelScreens.Home)
        } else {
            navController.navigateUp()
        }
    }

    fun navigate(destination: ScreenDestination, isTopLevelDestination: Boolean = false) {
        if (isTopLevelDestination) {
            navigateToTopLevelScreen(topLevelScreens.find { it.destination == destination }
                ?: TopLevelScreens.Home)
        } else {
            navController.navigate(destination)
        }
    }

    fun navigateToTopLevelScreen(destination: TopLevelScreens) {
        navController.navigate(destination.destination) {
            popUpTo(TopLevelScreens.Home.destination)
            launchSingleTop = true
        }
    }

    fun navigateToTopLevelScreen(route: ScreenDestination) {
        navController.navigate(route) {
            popUpTo(TopLevelScreens.Home.destination)
            launchSingleTop = true
        }
    }

    fun selectedTopLevelScreen() = when (navController.currentDestination?.route) {
        HomeScreenDestination.serializer().descriptor.serialName -> TopLevelScreens.Home
        UpdatesScreenDestination.serializer().descriptor.serialName -> TopLevelScreens.Updates
        PlansScreenDestination.serializer().descriptor.serialName -> TopLevelScreens.Plans
        MediaScreenDestination.serializer().descriptor.serialName -> TopLevelScreens.Media
        else -> TopLevelScreens.Home
    }
}
