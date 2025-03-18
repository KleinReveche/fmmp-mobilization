package ph.org.fmc.fmmp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.core.ui.icons.Newspaper
import ph.org.fmc.fmmp.core.ui.icons.Subscription
import ph.org.fmc.fmmp.core.ui.icons.SubscriptionFilled
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.home
import ph.org.fmc.fmmp.core.ui.resources.media
import ph.org.fmc.fmmp.core.ui.resources.plans
import ph.org.fmc.fmmp.core.ui.resources.updates
import ph.org.fmc.fmmp.features.home.HomeScreenDestination
import ph.org.fmc.fmmp.features.media.MediaScreenDestination
import ph.org.fmc.fmmp.features.plans.PlansScreenDestination
import ph.org.fmc.fmmp.features.updates.UpdatesScreenDestination

@Serializable
enum class TopLevelScreens(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: StringResource,
    val topAppBarText: StringResource,
    val destination: ScreenDestination
) {
    Home(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconText = Res.string.home,
        topAppBarText = Res.string.home,
        destination = HomeScreenDestination
    ),
    Plans(
        selectedIcon = Icons.Default.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        iconText = Res.string.plans,
        topAppBarText = Res.string.plans,
        destination = PlansScreenDestination
    ),
    Media(
        selectedIcon = SubscriptionFilled,
        unselectedIcon = Subscription,
        iconText = Res.string.media,
        topAppBarText = Res.string.media,
        destination = MediaScreenDestination
    ),
    Updates(
        selectedIcon = Newspaper,
        unselectedIcon = Newspaper,
        iconText = Res.string.updates,
        topAppBarText = Res.string.updates,
        destination = UpdatesScreenDestination
    )
}