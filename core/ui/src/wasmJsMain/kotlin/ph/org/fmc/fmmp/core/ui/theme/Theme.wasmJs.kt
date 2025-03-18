package ph.org.fmc.fmmp.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
actual fun SystemAppearance(isDark: Boolean) {

}

@Composable
actual fun AppColorScheme(
    isDark: Boolean,
    dynamicColorAndroid: Boolean,
    lightScheme: ColorScheme,
    darkScheme: ColorScheme
): ColorScheme = if (isDark) darkScheme else lightScheme