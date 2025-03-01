package ph.org.fmc.fmmp.features.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.compose.Markdown
import ph.org.fmc.fmmp.features.common.theme.getMarkdownColors
import ph.org.fmc.fmmp.features.common.theme.getMarkdownTypography

@Composable
fun StickyHeader(
    isExpanded: Boolean,
    title: String?,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        if (!isExpanded) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        if (title != null) {
            Markdown(
                content = "## **$title**",
                colors = getMarkdownColors(),
                typography = getMarkdownTypography(),
                modifier = Modifier
                    .padding(start = if (isExpanded) 0.dp else 16.dp)
                    .weight(1f)
            )
        }
    }
}