package ph.org.fmc.fmmp.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PsychologyAlt
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.window.core.layout.WindowWidthSizeClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.domain.models.BibleBook
import ph.org.fmc.fmmp.core.ui.AppTopBar
import ph.org.fmc.fmmp.core.ui.LocalDebug
import ph.org.fmc.fmmp.core.ui.LocalTopBar
import ph.org.fmc.fmmp.core.ui.ScreenDestination
import ph.org.fmc.fmmp.core.ui.components.ComingSoon
import ph.org.fmc.fmmp.core.ui.icons.Bible
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.devo
import ph.org.fmc.fmmp.core.ui.resources.devoOfTheDay
import ph.org.fmc.fmmp.core.ui.resources.insights
import ph.org.fmc.fmmp.core.ui.resources.verse
import ph.org.fmc.fmmp.core.ui.resources.verseOfTheDay
import ph.org.fmc.fmmp.core.ui.verticalScrollAndDrag
import ph.org.fmc.fmmp.features.home.components.HomeTopAppBar
import ph.org.fmc.fmmp.features.home.components.carousel.Carousel
import ph.org.fmc.fmmp.features.home.components.carousel.CarouselSection
import ph.org.fmc.fmmp.features.home.components.modal.VerseOfTheDay
import ph.org.fmc.fmmp.features.home.components.modal.VerseOfTheDayModal

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(showAppDrawer: () -> Unit = {}) {
    val vm: HomeScreenViewModel = viewModel { HomeScreenViewModel() }
    val isExpanded = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass != WindowWidthSizeClass.COMPACT
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val sections = arrayOf(
        CarouselSection(
            title = stringResource(if (isExpanded) Res.string.verseOfTheDay else Res.string.verse),
            icon = Bible,
            color = MaterialTheme.colorScheme.primaryContainer,
            currentImageUrl = Res.getUri("drawable/1Chr16_34-full.png")
        ),
        CarouselSection(
            title = stringResource(Res.string.insights),
            icon = Icons.Default.PsychologyAlt,
            color = MaterialTheme.colorScheme.secondaryContainer,
            currentImageUrl = Res.getUri("drawable/1Chr16_34-full.png")
        ),
        CarouselSection(
            title = stringResource(if (isExpanded) Res.string.devoOfTheDay else Res.string.devo),
            icon = Icons.Default.Favorite,
            color = MaterialTheme.colorScheme.tertiaryContainer,
            currentImageUrl = Res.getUri("drawable/1Chr16_34-full.png")
        )
    )
    val verseOfTheDay = VerseOfTheDay(
        bibleBook = BibleBook.FirstChronicles,
        startingChapter = 16,
        endingChapter = 16,
        startingVerse = 34,
        endingVerse = 34,
        translationAbbrev = "NIV",
        verseText = "Give thanks to the Lord, for he is good;\n    his love endures forever.",
        fullSizeImageUrl = Res.getUri("drawable/1Chr16_34-full.png"),
        smallSizeImageUrl = Res.getUri("drawable/1Chr16_34-small.png")
    )
    var topBar by LocalTopBar.current

    topBar = AppTopBar { HomeTopAppBar(showAppDrawer) }
    Column(
        modifier = Modifier
            .verticalScrollAndDrag(scrollState, scope = scope)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Carousel(sections) {
            when (it) {
                sections[0] -> vm.verseOfTheDayModal = true
                sections[1] -> vm.insightsModal = true
                sections[2] -> vm.devoOfTheDayModal = true
            }
        }

        if (!LocalDebug.current.value) {
            ComingSoon(
                featureDetails = listOf(
                    "Daily Verse",
                    "Highlights",
                    "And More!"
                )
            )
        }
    }

    if (vm.verseOfTheDayModal)
        VerseOfTheDayModal(isExpanded, verseOfTheDay, onDismiss = { vm.verseOfTheDayModal = false })
}

@Serializable
@SerialName("home")
object HomeScreenDestination : ScreenDestination