package ph.org.fmc.fmmp.features.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.domain.models.MediaType
import ph.org.fmc.fmmp.core.domain.models.User
import ph.org.fmc.fmmp.core.ui.CustomDialogPosition
import ph.org.fmc.fmmp.core.ui.customDialogModifier
import ph.org.fmc.fmmp.core.ui.icons.FmcLogo
import ph.org.fmc.fmmp.core.ui.icons.FoldedHands
import ph.org.fmc.fmmp.core.ui.platform.openUri
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.about
import ph.org.fmc.fmmp.core.ui.resources.fmmpFull
import ph.org.fmc.fmmp.core.ui.resources.help
import ph.org.fmc.fmmp.core.ui.resources.pgcFull
import ph.org.fmc.fmmp.core.ui.resources.prayers
import ph.org.fmc.fmmp.core.ui.resources.settings
import ph.org.fmc.fmmp.core.ui.resources.tutorialsAndFaqs
import ph.org.fmc.fmmp.core.ui.theme.LocalDebug
import ph.org.fmc.fmmp.core.ui.verticalScrollAndDrag
import kotlin.math.abs

private const val modalWidth = 210
private const val profileOffset = -40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActionsMenu(
    closePopup: () -> Unit,
    navigateToPrayers: () -> Unit,
    navigateToSettings: () -> Unit,
    navigateToHelp: () -> Unit,
    currentUser: User,
    currentAppVersion: String,
    pgcFacebookPage: String,
    fmmpFacebookPage: String
) {
    val modalScrollState = rememberScrollState()
    val modalCoroutineScope = rememberCoroutineScope()
    val systemUriHandler = LocalUriHandler.current
    var isDebugModeEnabled by LocalDebug.current
    var versionTapCount by remember { mutableIntStateOf(0) }

    Popup(
        alignment = Alignment.TopEnd,
        properties = PopupProperties(focusable = true),
        onDismissRequest = closePopup
    ) {
        Box(
            modifier = Modifier.fillMaxSize().wrapContentHeight(),
            contentAlignment = Alignment.TopEnd
        ) {
            Surface(
                modifier = Modifier.fillMaxSize().clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = closePopup
                ),
                color = Color.Black.copy(alpha = 0.5F),
                content = {}
            )

            Card(
                modifier = Modifier
                    .width(modalWidth.dp)
                    .wrapContentHeight()
                    .customDialogModifier(CustomDialogPosition.TOP_RIGHT),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.verticalScrollAndDrag(
                        scrollState = modalScrollState,
                        scope = modalCoroutineScope
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color(0xFF0E5C74))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = currentUser.email,
                            color = Color.White,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth().offset(x = 0.dp, y = profileOffset.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = currentUser.profilePictureUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .size((abs(profileOffset) * 2).dp)
                                .clip(CircleShape)
                                .background(Color.Gray)
                        )
                    }

                    Column(
                        Modifier.fillMaxWidth()
                            .offset(x = 0.dp, y = profileOffset.dp + (abs(profileOffset) / 2).dp)
                    ) {
                        MenuItemRow(
                            icon = FoldedHands,
                            title = stringResource(Res.string.prayers),
                            onClick = navigateToPrayers
                        )

                        MenuItemRow(
                            icon = Icons.Outlined.Settings,
                            title = stringResource(Res.string.settings),
                            onClick = navigateToSettings
                        )
                        CategoryRow(stringResource(Res.string.help))

                        MenuItemRow(
                            icon = Icons.AutoMirrored.Outlined.Help,
                            title = stringResource(Res.string.tutorialsAndFaqs),
                            onClick = navigateToHelp
                        )

                        CategoryRow(stringResource(Res.string.about))

                        MenuItemRow(
                            icon = Icons.Outlined.Info,
                            title = stringResource(Res.string.fmmpFull),
                            onClick = {
                                modalCoroutineScope.launch {
                                    openUri(fmmpFacebookPage, MediaType.FACEBOOK, systemUriHandler)
                                }
                            }
                        )

                        MenuItemRow(
                            icon = FmcLogo,
                            title = stringResource(Res.string.pgcFull),
                            onClick = {
                                modalCoroutineScope.launch {
                                    openUri(pgcFacebookPage, MediaType.FACEBOOK, systemUriHandler)
                                }
                            }
                        )

                        MenuItemRow(
                            icon = Icons.Outlined.Description,
                            title = "v$currentAppVersion",
                            onClick = {
                                versionTapCount++
                                if (versionTapCount == 7) {
                                    versionTapCount = 0
                                    isDebugModeEnabled = !isDebugModeEnabled
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItemRow(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    isLastItem: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp, 5.dp, 16.dp, if (isLastItem) 0.dp else 5.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.outline,
            fontSize = 16.sp
        )
    }
}

@Composable
fun CategoryRow(title: String) {
    Row(
        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            color = Color(0xFF64748B),
            fontSize = 12.sp,
        )

        HorizontalDivider(
            color = Color(0xFF334155),
            thickness = 1.dp,
            modifier = Modifier.padding(end = 10.dp, start = 5.dp, top = 2.dp, bottom = 2.dp)
        )
    }
}