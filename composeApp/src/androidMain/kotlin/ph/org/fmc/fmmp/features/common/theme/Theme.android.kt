package ph.org.fmc.fmmp.features.common.theme

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

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

    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && dynamicColorAndroid ->
            dynamicTheme(darkTheme, oled, LocalContext.current)
        darkTheme -> darkColorScheme
        else -> lightScheme
    }

    MaterialTheme(colorScheme = colorScheme, content = content)
}


@RequiresApi(Build.VERSION_CODES.S)
private fun dynamicTheme(
    darkTheme: Boolean,
    oled: Boolean,
    context: Context,
) = if (darkTheme) {
    if (!oled) {
        dynamicDarkColorScheme(context).copy(surface = Color.Black, background = Color.Black)
    } else {
        dynamicDarkColorScheme(context)
    }
} else {
    dynamicLightColorScheme(context)
}