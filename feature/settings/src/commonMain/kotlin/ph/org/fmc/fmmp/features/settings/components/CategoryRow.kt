package ph.org.fmc.fmmp.features.settings.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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