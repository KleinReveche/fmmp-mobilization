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
import ph.org.fmc.fmmp.features.navigation.ScreenDestination
import ph.org.fmc.fmmp.features.navigation.TopLevelScreens

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): FmmpMobilizationAppState {
    return remember(
        navController,
        coroutineScope,
        snackbarHostState
    ) {
        FmmpMobilizationAppState(
            navController = navController,
            coroutineScope = coroutineScope,
            snackbarHostState = snackbarHostState
        )
    }
}

@Stable
class FmmpMobilizationAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    val snackbarHostState: SnackbarHostState,
    val topBar: @Composable (() -> Unit)? = null,
    val bottomBar: @Composable (() -> Unit)? = null,
) {
    val screens = TopLevelScreens.entries
    var currentTopLevelScreen by mutableStateOf(TopLevelScreens.Home)

    fun navigateUp() {
        val currentDestination = navController.currentBackStackEntry
        if (screens.any { it.destination::class.qualifiedName == currentDestination?.destination?.route }) {
            navigateToTopLevelScreen(TopLevelScreens.Home)
        } else {
            navController.navigateUp()
        }
    }

    fun navigate(screen: ScreenDestination, isTopLevel: Boolean = false) {
        if (isTopLevel) {
            navigateToTopLevelScreen(screens.find { it.destination == screen }
                ?: TopLevelScreens.Home)
        } else {
            navController.navigate(screen)
        }
    }

    fun navigateToTopLevelScreen(screen: TopLevelScreens) {
        currentTopLevelScreen = screen
        navController.navigate(screen.destination) {
            popUpTo(TopLevelScreens.Home.destination)
            launchSingleTop = true
        }
    }
}
