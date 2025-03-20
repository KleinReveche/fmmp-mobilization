package ph.org.fmc.fmmp.features.home.components.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.domain.models.BibleBook
import ph.org.fmc.fmmp.core.ui.components.PopupCard
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.verseOfTheDay

@Composable
fun VerseOfTheDayModal(
    isExpanded: Boolean,
    verseOfTheDay: VerseOfTheDay,
    onDismiss: () -> Unit
) {
    if (isExpanded) {
        ModalDialog(verseOfTheDay, onDismiss)
    } else {
        ModalBottomSheet(verseOfTheDay, onDismiss)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalBottomSheet(verseOfTheDay: VerseOfTheDay, onDismiss: () -> Unit) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        dragHandle = {
            Box(contentAlignment = Alignment.TopCenter) {
                AsyncImage(
                    model = verseOfTheDay.fullSizeImageUrl,
                    contentDescription = "Verse background",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                Surface(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color.DarkGray,
                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    Box(Modifier.size(width = 32.dp, height = 4.dp))
                }
            }
        }
    ) {
        ModalContent(verseOfTheDay, modifier = Modifier.padding(16.dp))
    }
}

@Composable
private fun ModalDialog(verseOfTheDay: VerseOfTheDay, onDismiss: () -> Unit) {
    Popup(
        alignment = Alignment.Center,
        properties = PopupProperties(focusable = true),
        onDismissRequest = onDismiss
    ) {
        PopupCard(
            cardTitle = stringResource(Res.string.verseOfTheDay),
            isPopup = true,
            closePopup = onDismiss
        ) {
            ModalContent(
                verseOfTheDay,
                modifier = Modifier.padding(8.dp)
            )

            HorizontalDivider(Modifier.fillMaxWidth(0.45F).padding(16.dp))

            AsyncImage(
                model = verseOfTheDay.smallSizeImageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.45F)
                    .aspectRatio(1.0F)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(12.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun ModalContent(verseOfTheDay: VerseOfTheDay, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = verseOfTheDay.verseText,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Text(
            text = "${verseOfTheDay.bibleBook.name
                .replace("First", "1 ")
                .replace("Second", "2 ")
                .replace("Third", "3 ")} " +
                    "${verseOfTheDay.startingChapter}:${verseOfTheDay.startingVerse}" +
                    (if (verseOfTheDay.endingVerse > verseOfTheDay.startingVerse) "-${verseOfTheDay.endingVerse}" else "") +
                    " (${verseOfTheDay.translationAbbrev})",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.End)
        )
    }
}

data class VerseOfTheDay(
    val bibleBook: BibleBook,
    val startingChapter: Int,
    val endingChapter: Int,
    val startingVerse: Int,
    val endingVerse: Int,
    val translationAbbrev: String,
    val verseText: String,
    val fullSizeImageUrl: String,
    val smallSizeImageUrl: String,
)