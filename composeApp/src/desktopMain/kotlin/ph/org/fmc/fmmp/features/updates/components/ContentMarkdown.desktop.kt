package ph.org.fmc.fmmp.features.updates.components

import androidx.compose.runtime.Composable
import com.mikepenz.markdown.coil3.Coil3ImageTransformerImpl
import com.mikepenz.markdown.compose.Markdown
import ph.org.fmc.fmmp.features.common.theme.getMarkdownColors
import ph.org.fmc.fmmp.features.common.theme.getMarkdownTypography

@Composable
actual fun ContentMarkdown(content: String) {
    Markdown(
        content = content,
        colors = getMarkdownColors(),
        typography = getMarkdownTypography(),
        imageTransformer = Coil3ImageTransformerImpl
    )
}