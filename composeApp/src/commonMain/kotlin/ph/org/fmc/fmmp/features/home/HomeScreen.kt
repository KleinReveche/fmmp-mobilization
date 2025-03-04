package ph.org.fmc.fmmp.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.features.common.components.ComingSoon
import ph.org.fmc.fmmp.features.navigation.ScreenDestination

@Composable
fun HomeScreen() {
    val vm: HomeScreenViewModel = viewModel { HomeScreenViewModel() }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ComingSoon(
            featureDetails = listOf(
                "Daily Verse",
                "Highlights",
                "And More!"
            )
        )
    }
}

@Serializable
object HomeScreenDestination : ScreenDestination

