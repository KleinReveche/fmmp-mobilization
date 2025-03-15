package ph.org.fmc.fmmp.features.updates.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mikepenz.markdown.coil3.Coil3ImageTransformerImpl
import com.mikepenz.markdown.compose.Markdown
import kotlinx.datetime.format.MonthNames
import org.jetbrains.compose.resources.stringArrayResource
import ph.org.fmc.fmmp.domain.models.NewsUpdate
import ph.org.fmc.fmmp.features.common.components.StickyHeader
import ph.org.fmc.fmmp.features.common.icons.Favorite
import ph.org.fmc.fmmp.features.common.theme.getMarkdownColors
import ph.org.fmc.fmmp.features.common.theme.getMarkdownTypography
import ph.org.fmc.fmmp.features.common.verticalScrollAndDrag
import ph.org.fmc.fmmp.getPlatform
import ph.org.fmc.fmmp.resources.Res
import ph.org.fmc.fmmp.resources.monthNames

@Composable
fun UpdateContentItem(
    newsUpdate: NewsUpdate,
    isExpanded: Boolean,
    onBackClick: () -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val monthNames = if (getPlatform().name.startsWith("Web")) {
        MonthNames.ENGLISH_FULL.names
    } else {
        stringArrayResource(Res.array.monthNames)
    }
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    var headerPadding by remember { mutableStateOf(0.dp) }

    Card(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .verticalScrollAndDrag(
                        scrollState = scrollState,
                        scope = scope
                    )
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(top = headerPadding)
            ) {
                // Content below header
                Markdown(
                    content = newsUpdate.content,
                    colors = getMarkdownColors(),
                    typography = getMarkdownTypography(),
                    imageTransformer = Coil3ImageTransformerImpl
                )

                Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 8.dp)) {
                    AuthorImage(
                        newsUpdate.authorImage,
                        newsUpdate.authorName,
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = newsUpdate.authorName,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = newsUpdate.getFormattedPublishDate(monthNames),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                    ) {
                        Icon(
                            imageVector = Favorite,
                            contentDescription = "Favorite",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Button(
                        onClick = onPreviousClick,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceBright
                        )
                    ) {
                        Text(
                            text = "Previous",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Button(
                        onClick = onNextClick,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceBright
                        )
                    ) {
                        Text(
                            text = "Next",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            StickyHeader(
                title = newsUpdate.title,
                onBackClick = onBackClick,
                isExpanded = isExpanded,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh.copy(alpha = 0.95f))
                    .zIndex(1f)
                    .padding(10.dp)
                    .onGloballyPositioned { layoutCoordinates ->
                        headerPadding = layoutCoordinates.size.height.dp + 16.dp
                    }
            )
        }
    }
}