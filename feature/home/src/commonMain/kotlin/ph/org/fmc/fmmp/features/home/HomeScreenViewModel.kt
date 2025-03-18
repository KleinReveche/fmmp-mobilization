package ph.org.fmc.fmmp.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ph.org.fmc.fmmp.core.domain.models.BibleBook
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.features.home.components.modal.VerseOfTheDay

class HomeScreenViewModel : ViewModel() {
     var verseOfTheDayModal by mutableStateOf(false)
     var insightsModal by mutableStateOf(false)
     var devoOfTheDayModal by mutableStateOf(false)

     @OptIn(ExperimentalResourceApi::class)
     var verseOfTheDay by mutableStateOf(
          VerseOfTheDay(
               bibleBook = BibleBook.FirstChronicles,
               startingChapter = 16,
               endingChapter = 16,
               startingVerse = 34,
               endingVerse = 34,
               translation = "NIV",
               verseText = "Give thanks to the Lord, for he is good;\n    his love endures forever.",
               fullSizeImageUrl = Res.getUri("drawable/1Chr16_34-full.png"),
               smallSizeImageUrl = Res.getUri("drawable/1Chr16_34-small.png")
          )
     )
}