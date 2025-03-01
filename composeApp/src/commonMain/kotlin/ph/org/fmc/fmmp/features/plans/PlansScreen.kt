package ph.org.fmc.fmmp.features.plans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.features.navigation.ScreenDestination

@Composable
fun PlansScreen(
    navigate: (screen: ScreenDestination, isTopLevel: Boolean) -> Unit,
    navigateUp: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Plans Screen")
    }
}

@Serializable
object PlansScreenDestination : ScreenDestination