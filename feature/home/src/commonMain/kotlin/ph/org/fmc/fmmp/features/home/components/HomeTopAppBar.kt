package ph.org.fmc.fmmp.features.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.data.getPlatform
import ph.org.fmc.fmmp.core.domain.models.Platforms
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.daysOfWeekNames
import ph.org.fmc.fmmp.core.ui.resources.goodAfternoon
import ph.org.fmc.fmmp.core.ui.resources.goodEvening
import ph.org.fmc.fmmp.core.ui.resources.goodMorning
import ph.org.fmc.fmmp.core.ui.resources.monthNames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(showAppDrawer: () -> Unit = {}) {
    val date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val greeting = when (date.hour) {
        in 0..11 -> Res.string.goodMorning
        in 12..17 -> Res.string.goodAfternoon
        else -> Res.string.goodEvening
    }
    val (dayOfWeekNames, monthNames) = when (getPlatform().name == Platforms.WasmJs) {
        true -> Pair(DayOfWeekNames.ENGLISH_FULL.names, MonthNames.ENGLISH_FULL.names)
        false -> Pair(stringArrayResource(Res.array.daysOfWeekNames), stringArrayResource(Res.array.monthNames))
    }
    val format = LocalDateTime.Format {
        dayOfWeek(DayOfWeekNames(dayOfWeekNames))
        chars(", ")
        monthName(MonthNames(monthNames))
        char(' ')
        dayOfMonth()
    }

    TopAppBar(
        title = {
            Column {
                Text(text = stringResource(greeting))
                Text(text = format.format(date), style = MaterialTheme.typography.bodyMedium)
            }
        },
        actions = {
            IconButton(onClick = showAppDrawer) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Open App Drawer"
                )
            }
        }
    )
}