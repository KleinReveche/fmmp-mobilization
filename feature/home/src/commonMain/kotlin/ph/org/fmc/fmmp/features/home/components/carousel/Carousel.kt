package ph.org.fmc.fmmp.features.home.components.carousel

import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Carousel(sections: Array<CarouselSection> = emptyArray(), onClick: (CarouselSection) -> Unit) {
    val pagerState = rememberPagerState(pageCount = { sections.size })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % sections.size
            pagerState.animateScrollToPage(
                page = nextPage,
                animationSpec = tween(durationMillis = 800)
            )
        }
    }

    Box(modifier = Modifier.size(width = 800.dp, height = 540.dp)) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragEnd = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage)
                            }
                        }
                    ) { change, dragAmount ->
                        change.consume()
                        coroutineScope.launch {
                            pagerState.scrollBy(-dragAmount.x)
                        }
                    }
                },
        ) { page ->
            val section = sections[page]
            CarouselCard(
                pagerState = pagerState,
                currentPage = page,
                imageUrl = section.currentImageUrl,
                onClick = { onClick(section) }
            )
        }

        PillBarIndicators(
            sections = sections,
            pagerState = pagerState,
            coroutineScope = coroutineScope,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp)
                .zIndex(1f)
        )
    }
}

data class CarouselSection(
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val currentImageUrl: String
)