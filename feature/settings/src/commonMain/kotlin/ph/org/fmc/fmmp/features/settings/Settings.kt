package ph.org.fmc.fmmp.features.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AlignHorizontalLeft
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DisplaySettings
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.ImagesearchRoller
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.domain.models.User
import ph.org.fmc.fmmp.core.ui.LocalBibleDisplaySettings
import ph.org.fmc.fmmp.core.ui.LocalTheme
import ph.org.fmc.fmmp.core.ui.components.PopupCard
import ph.org.fmc.fmmp.core.ui.icons.Bible
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.accountCategoryDescription
import ph.org.fmc.fmmp.core.ui.resources.bibleCategory
import ph.org.fmc.fmmp.core.ui.resources.bibleCategoryDescription
import ph.org.fmc.fmmp.core.ui.resources.bibleChapterVerseNumbers
import ph.org.fmc.fmmp.core.ui.resources.bibleVerseLine
import ph.org.fmc.fmmp.core.ui.resources.darkMode
import ph.org.fmc.fmmp.core.ui.resources.generalCategory
import ph.org.fmc.fmmp.core.ui.resources.generalCategoryDescription
import ph.org.fmc.fmmp.core.ui.resources.help
import ph.org.fmc.fmmp.core.ui.resources.helpCategoryDescription
import ph.org.fmc.fmmp.core.ui.resources.manageAccount
import ph.org.fmc.fmmp.core.ui.resources.oledMode
import ph.org.fmc.fmmp.core.ui.resources.redLetter
import ph.org.fmc.fmmp.core.ui.resources.settings
import ph.org.fmc.fmmp.core.ui.resources.tutorialsAndFaqs
import ph.org.fmc.fmmp.features.settings.components.SettingsCategoryContent
import ph.org.fmc.fmmp.features.settings.components.SettingsNavigationItem
import ph.org.fmc.fmmp.features.settings.components.SettingsSwitchItem

data class SettingsData(
    val user: User,
    val closeSettings: () -> Unit,
    val navigateToManageAccount: () -> Unit,
    val navigateToTutorialsAndFaqs: () -> Unit,
)

@Composable
fun Settings(
    settingsData: SettingsData,
    isPopup: Boolean = false
) {
    var theme by LocalTheme.current
    var bibleVerseDisplaySettings by LocalBibleDisplaySettings.current
    val fillMaxWidthFraction = if (isPopup) 0.5F else 1F

    PopupCard(stringResource(Res.string.settings), isPopup, settingsData.closeSettings) {
        SettingCategory(
            icon = Icons.Default.AccountCircle,
            title = settingsData.user.email,
            description = stringResource(Res.string.accountCategoryDescription),
            fillMaxWidthFraction = fillMaxWidthFraction
        )

        SettingsCategoryContent(
            fillMaxWidthFraction,
            arrayOf(
                {
                    SettingsNavigationItem(
                        icon = Icons.Default.AccountCircle,
                        title = stringResource(Res.string.manageAccount),
                        onClick = settingsData.navigateToManageAccount
                    )
                }
            )
        )

        SettingCategory(
            icon = Icons.Default.Phone,
            title = stringResource(Res.string.generalCategory),
            description = stringResource(Res.string.generalCategoryDescription),
            fillMaxWidthFraction = fillMaxWidthFraction
        )

        SettingsCategoryContent(
            fillMaxWidthFraction,
            arrayOf(
                {
                    SettingsSwitchItem(
                        icon = Icons.Default.DarkMode,
                        title = stringResource(Res.string.darkMode),
                        checked = theme.isDark,
                        onCheckedChange = { theme = theme.copy(isDark = it) }
                    )
                },
                {
                    SettingsSwitchItem(
                        icon = Icons.Default.DisplaySettings,
                        title = stringResource(Res.string.oledMode),
                        checked = theme.isOled,
                        onCheckedChange = { theme = theme.copy(isOled = it) },
                        isLastItem = true
                    )
                }
            )
        )

        SettingCategory(
            icon = Bible,
            title = stringResource(Res.string.bibleCategory),
            description = stringResource(Res.string.bibleCategoryDescription),
            fillMaxWidthFraction = fillMaxWidthFraction
        )

        SettingsCategoryContent(
            fillMaxWidthFraction,
            arrayOf(
                {
                    SettingsSwitchItem(
                        icon = Icons.Default.ImagesearchRoller,
                        title = stringResource(Res.string.redLetter),
                        checked = bibleVerseDisplaySettings.redLetter,
                        onCheckedChange = {
                            bibleVerseDisplaySettings =
                                bibleVerseDisplaySettings.copy(redLetter = it)
                        }
                    )
                },
                {
                    SettingsSwitchItem(
                        icon = Icons.AutoMirrored.Filled.AlignHorizontalLeft,
                        title = stringResource(Res.string.bibleVerseLine),
                        checked = bibleVerseDisplaySettings.verseLine,
                        onCheckedChange = {
                            bibleVerseDisplaySettings =
                                bibleVerseDisplaySettings.copy(verseLine = it)
                        }
                    )
                },
                {
                    SettingsSwitchItem(
                        icon = Icons.Default.FormatListNumbered,
                        title = stringResource(Res.string.bibleChapterVerseNumbers),
                        checked = bibleVerseDisplaySettings.chapterVerseNumbers,
                        onCheckedChange = {
                            bibleVerseDisplaySettings =
                                bibleVerseDisplaySettings.copy(chapterVerseNumbers = it)
                        },
                        isLastItem = true
                    )
                }
            )
        )

        SettingCategory(
            icon = Icons.AutoMirrored.Outlined.Help,
            title = stringResource(Res.string.help),
            description = stringResource(Res.string.helpCategoryDescription),
            fillMaxWidthFraction = fillMaxWidthFraction
        )

        SettingsCategoryContent(
            fillMaxWidthFraction,
            arrayOf(
                {
                    SettingsNavigationItem(
                        icon = Icons.Outlined.Info,
                        title = stringResource(Res.string.tutorialsAndFaqs),
                        onClick = settingsData.navigateToTutorialsAndFaqs
                    )
                }
            )
        )
    }
}

@Composable
fun SettingCategory(
    icon: ImageVector,
    title: String,
    description: String,
    fillMaxWidthFraction: Float
) {
    Column(
        modifier = Modifier.fillMaxWidth(fillMaxWidthFraction)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(8.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}