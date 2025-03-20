package ph.org.fmc.fmmp.features.home.components.carousel

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlin.math.absoluteValue

@Composable
fun CarouselCard(
    pagerState: PagerState,
    currentPage: Int,
    imageUrl: String,
    onClick: () -> Unit
) {
    val pageOffset =
        ((pagerState.currentPage - currentPage) + pagerState.currentPageOffsetFraction).absoluteValue

    val scale by animateFloatAsState(
        targetValue = if (pageOffset < 0.5) 1f else 0.9f,
        animationSpec = tween(durationMillis = 300)
    )

    val alpha by animateFloatAsState(
        targetValue = if (pageOffset < 0.5) 1f else 0.6f,
        animationSpec = tween(durationMillis = 300)
    )

    Card(
        modifier = Modifier
            .padding(16.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
            }
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
    }
}