package ph.org.fmc.fmmp.features.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun FmmpMobilizationTheme(
    dynamicColorAndroid: Boolean,
    darkTheme: Boolean,
    oled: Boolean,
    content: @Composable () -> Unit
) {
    val darkColorScheme = darkScheme.copy(
        background = if (oled) scrimDark else backgroundDark,
        surface = if (oled) scrimDark else surfaceDark,
    )
    val colorScheme = if (darkTheme) darkColorScheme else lightScheme

    MaterialTheme(colorScheme = colorScheme, content = content)
}