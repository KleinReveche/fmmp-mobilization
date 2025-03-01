package ph.org.fmc.fmmp.features.updates.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun AuthorImage(
    imageUrl: String,
    description: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape),
        model = imageUrl,
        contentDescription = description,
    )
}