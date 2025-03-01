package ph.org.fmc.fmmp.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.features.navigation.ScreenDestination

@Composable
fun HomeScreen(
    navigate: (screen: ScreenDestination, isTopLevel: Boolean) -> Unit,
    navigateUp: () -> Unit
) {
    val vm: HomeScreenViewModel = viewModel { HomeScreenViewModel() }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Home Screen")
    }
}

@Serializable
object HomeScreenDestination : ScreenDestination

