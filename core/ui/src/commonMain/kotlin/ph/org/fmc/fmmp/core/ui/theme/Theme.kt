package ph.org.fmc.fmmp.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import ph.org.fmc.fmmp.core.domain.getPlatform
import ph.org.fmc.fmmp.core.domain.models.Platforms
import ph.org.fmc.fmmp.core.ui.AppTopBar
import ph.org.fmc.fmmp.core.ui.BibleVerseDisplaySettings
import ph.org.fmc.fmmp.core.ui.LocalBibleDisplaySettings
import ph.org.fmc.fmmp.core.ui.LocalDebug
import ph.org.fmc.fmmp.core.ui.LocalGlobalPadding
import ph.org.fmc.fmmp.core.ui.LocalTheme
import ph.org.fmc.fmmp.core.ui.LocalTopBar
import ph.org.fmc.fmmp.core.ui.Theme

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = TertiaryLight,
    onTertiary = OnTertiaryLight,
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    scrim = ScrimLight,
    inverseSurface = InverseSurfaceLight,
    inverseOnSurface = InverseOnSurfaceLight,
    inversePrimary = InversePrimaryLight,
    surfaceDim = SurfaceDimLight,
    surfaceBright = SurfaceBrightLight,
    surfaceContainerLowest = SurfaceContainerLowestLight,
    surfaceContainerLow = SurfaceContainerLowLight,
    surfaceContainer = SurfaceContainerLight,
    surfaceContainerHigh = SurfaceContainerHighLight,
    surfaceContainerHighest = SurfaceContainerHighestLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryDark,
    onTertiary = OnTertiaryDark,
    tertiaryContainer = TertiaryContainerDark,
    onTertiaryContainer = OnTertiaryContainerDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
    outlineVariant = OutlineVariantDark,
    scrim = ScrimDark,
    inverseSurface = InverseSurfaceDark,
    inverseOnSurface = InverseOnSurfaceDark,
    inversePrimary = InversePrimaryDark,
    surfaceDim = SurfaceDimDark,
    surfaceBright = SurfaceBrightDark,
    surfaceContainerLowest = SurfaceContainerLowestDark,
    surfaceContainerLow = SurfaceContainerLowDark,
    surfaceContainer = SurfaceContainerDark,
    surfaceContainerHigh = SurfaceContainerHighDark,
    surfaceContainerHighest = SurfaceContainerHighestDark,
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val theme = remember(false) {
        mutableStateOf(
            Theme(
                systemIsDark,
                isDynamicColorAndroid = false,
                isOled = false
            )
        )
    }
    val platform = getPlatform()
    val isWasmJsOnAndroid =
        platform.name == Platforms.WasmJs && platform.version.contains("Android")
    val isWasmJsOnIPhone =
        platform.name == Platforms.WasmJs && platform.version.lowercase().contains("iphone")
    val debugState = remember(false) { mutableStateOf(false) }
    val bibleVerseDisplaySettings = remember(false) { mutableStateOf(BibleVerseDisplaySettings()) }
    val topBar = remember(false) { mutableStateOf(AppTopBar { }) }
    val globalPadding = remember(false) {
        mutableStateOf(
            when {
                isWasmJsOnAndroid -> PaddingValues(bottom = 56.dp)
                isWasmJsOnIPhone -> PaddingValues(bottom = 20.dp)
                else -> PaddingValues()
            }
        )
    }

    CompositionLocalProvider(
        LocalTheme provides theme,
        LocalDebug provides debugState,
        LocalBibleDisplaySettings provides bibleVerseDisplaySettings,
        LocalTopBar provides topBar,
        LocalGlobalPadding provides globalPadding
    ) {
        val appTheme by theme

        val colorScheme = AppColorScheme(
            appTheme.isDark,
            appTheme.isDynamicColorAndroid,
            LightColorScheme,
            DarkColorScheme.copy(
                background = if (appTheme.isOled) ScrimDark else BackgroundDark,
                surface = if (appTheme.isOled) ScrimDark else SurfaceDark
            )
        )

        SystemAppearance(!appTheme.isDark)
        MaterialTheme(
            colorScheme = colorScheme,
            content = { Surface(content = content) }
        )
    }
}

@Composable
internal expect fun AppColorScheme(
    isDark: Boolean,
    dynamicColorAndroid: Boolean,
    lightScheme: ColorScheme,
    darkScheme: ColorScheme
): ColorScheme

@Composable
internal expect fun SystemAppearance(isDark: Boolean)