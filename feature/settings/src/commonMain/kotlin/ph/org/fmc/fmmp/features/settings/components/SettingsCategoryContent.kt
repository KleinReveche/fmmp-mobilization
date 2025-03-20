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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsCategoryContent(fillMaxWidthFraction: Float, contents: Array<@Composable () -> Unit>) {
    Box(
        modifier = Modifier
            .padding(18.dp)
            .background(MaterialTheme.colorScheme.surfaceContainerHighest, RoundedCornerShape(8.dp))
            .fillMaxWidth(fillMaxWidthFraction)
    ) {
        Column {
            contents.forEachIndexed { index, content ->
                content()
                if (index < contents.size - 1) {
                    HorizontalDivider(Modifier.padding(horizontal = 12.dp))
                }
            }
        }
    }
}
