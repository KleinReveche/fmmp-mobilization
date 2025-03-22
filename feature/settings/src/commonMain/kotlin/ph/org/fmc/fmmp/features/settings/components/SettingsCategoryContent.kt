package ph.org.fmc.fmmp.features.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsCategoryContent(fillMaxWidthFraction: Float, contents: Array<@Composable (() -> Unit)?>) {
    val nullCount by remember { mutableIntStateOf(contents.count { it == null }) }

    Box(
        modifier = Modifier
            .padding(18.dp)
            .background(MaterialTheme.colorScheme.surfaceContainerHighest, RoundedCornerShape(8.dp))
            .fillMaxWidth(fillMaxWidthFraction)
    ) {
        Column {
            contents.forEachIndexed { index, content ->
                if (content == null) return@forEachIndexed
                content()
                if (index < contents.size - (1 + nullCount)) {
                    HorizontalDivider(Modifier.padding(horizontal = 12.dp))
                }
            }
        }
    }
}
