package ph.org.fmc.fmmp.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextLinkStyles
import com.mikepenz.markdown.model.DefaultMarkdownColors
import com.mikepenz.markdown.model.DefaultMarkdownTypography

@Composable
fun getMarkdownColors() = DefaultMarkdownColors(
    text = MaterialTheme.colorScheme.onSurfaceVariant,
    codeText = MaterialTheme.colorScheme.primary,
    inlineCodeText = MaterialTheme.colorScheme.secondary,
    linkText = MaterialTheme.colorScheme.primary,
    codeBackground = MaterialTheme.colorScheme.surfaceVariant,
    inlineCodeBackground = MaterialTheme.colorScheme.surface,
    dividerColor = MaterialTheme.colorScheme.outline,
    tableText = MaterialTheme.colorScheme.onSurface,
    tableBackground = MaterialTheme.colorScheme.surface
)

@Composable
fun getMarkdownTypography() = DefaultMarkdownTypography(
    h1 = MaterialTheme.typography.headlineLarge,
    h2 = MaterialTheme.typography.headlineMedium,
    h3 = MaterialTheme.typography.headlineSmall,
    h4 = MaterialTheme.typography.titleLarge,
    h5 = MaterialTheme.typography.titleMedium,
    h6 = MaterialTheme.typography.titleSmall,
    text = MaterialTheme.typography.bodyLarge,
    code = MaterialTheme.typography.bodyMedium,
    inlineCode = MaterialTheme.typography.bodySmall,
    quote = MaterialTheme.typography.bodyLarge,
    paragraph = MaterialTheme.typography.bodyMedium,
    ordered = MaterialTheme.typography.bodyMedium,
    bullet = MaterialTheme.typography.bodyMedium,
    list = MaterialTheme.typography.bodyMedium,
    link = MaterialTheme.typography.bodyMedium,
    textLink = TextLinkStyles(),
    table = MaterialTheme.typography.bodyMedium
)