package ph.org.fmc.fmmp.features.plans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.core.ui.components.ComingSoon

@Composable
fun PlansScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ComingSoon(
            featureDetails = listOf(
                "Devotionals",
                "Bible Reading Plans",
                "And More!"
            )
        )
    }
}

@Serializable
object PlansScreenDestination : ScreenDestination