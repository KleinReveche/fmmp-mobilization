package ph.org.fmc.fmmp.features.updates.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
actual fun ContentMarkdown(content: String) {
    Text(
        text = content,
        style = MaterialTheme.typography.bodyMedium,
    )
}