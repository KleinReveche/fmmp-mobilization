package ph.org.fmc.fmmp.core.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

data class Theme(
    val isDark: Boolean = true,
    val isDynamicColorAndroid: Boolean = false,
    val isOled: Boolean = false
)

data class BibleVerseDisplaySettings(
    val redLetter: Boolean = true,
    val verseLine: Boolean = false,
    val chapterVerseNumbers: Boolean = true
)

data class AppTopBar(
    val topBar: @Composable () -> Unit
)

val LocalTheme = compositionLocalOf { mutableStateOf(Theme()) }
val LocalBibleDisplaySettings = compositionLocalOf { mutableStateOf(BibleVerseDisplaySettings()) }
val LocalDebug = compositionLocalOf { mutableStateOf(false) }
val LocalTopBar = compositionLocalOf { mutableStateOf(AppTopBar { }) }
val LocalGlobalPadding = compositionLocalOf { mutableStateOf(PaddingValues()) }