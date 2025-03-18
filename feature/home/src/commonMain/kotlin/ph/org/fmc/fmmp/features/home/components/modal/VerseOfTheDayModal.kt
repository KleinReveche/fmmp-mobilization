package ph.org.fmc.fmmp.features.home.components.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ph.org.fmc.fmmp.core.domain.models.BibleBook
import ph.org.fmc.fmmp.core.ui.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun VerseOfTheDayModal(
    isExpanded: Boolean,
    verseOfTheDay: VerseOfTheDay = VerseOfTheDay(
        bibleBook = BibleBook.FirstChronicles,
        startingChapter = 16,
        endingChapter = 16,
        startingVerse = 34,
        endingVerse = 34,
        translation = "NIV",
        verseText = "Give thanks to the Lord, for he is good;\n    his love endures forever.",
        fullSizeImageUrl = Res.getUri("drawable/1Chr16_34-full.png"),
        smallSizeImageUrl = Res.getUri("drawable/1Chr16_34-small.png")
    ),
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
        sheetState = rememberModalBottomSheetState(),
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        ModalContent(verseOfTheDay, false, modifier = Modifier.padding(16.dp))
    }
}

@Composable
private fun ModalDialog(verseOfTheDay: VerseOfTheDay, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        },
        text = {
            ModalContent(
                verseOfTheDay,
                isExpanded = true,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    )
}

@Composable
private fun ModalContent(verseOfTheDay: VerseOfTheDay, isExpanded: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (!isExpanded) {
            AsyncImage(
                model = verseOfTheDay.fullSizeImageUrl,
                contentDescription = "Verse background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = verseOfTheDay.verseText,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "${verseOfTheDay.bibleBook.name
                .replace("First", "1 ")
                .replace("Second", "2 ")
                .replace("Third", "3 ")} " +
                    "${verseOfTheDay.startingChapter}:${verseOfTheDay.startingVerse}" +
                    (if (verseOfTheDay.endingVerse > verseOfTheDay.startingVerse) "-${verseOfTheDay.endingVerse}" else "") +
                    " (${verseOfTheDay.translation})",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        if (isExpanded) {
            HorizontalDivider()

            AsyncImage(
                model = verseOfTheDay.smallSizeImageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

data class VerseOfTheDay(
    val bibleBook: BibleBook,
    val startingChapter: Int,
    val endingChapter: Int,
    val startingVerse: Int,
    val endingVerse: Int,
    val translation: String,
    val verseText: String,
    val fullSizeImageUrl: String,
    val smallSizeImageUrl: String,
)