package ph.org.fmc.fmmp.features.common.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Subscription: ImageVector
    get() {
        if (_Subscription != null) {
            return _Subscription!!
        }
        _Subscription = ImageVector.Builder(
            name = "Subscription",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(160f, 880f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(80f, 800f)
                verticalLineToRelative(-400f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(160f, 320f)
                horizontalLineToRelative(640f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(880f, 400f)
                verticalLineToRelative(400f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(800f, 880f)
                lineTo(160f, 880f)
                close()
                moveTo(160f, 800f)
                horizontalLineToRelative(640f)
                verticalLineToRelative(-400f)
                lineTo(160f, 400f)
                verticalLineToRelative(400f)
                close()
                moveTo(400f, 760f)
                lineTo(640f, 600f)
                lineTo(400f, 440f)
                verticalLineToRelative(320f)
                close()
                moveTo(160f, 280f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(640f)
                verticalLineToRelative(80f)
                lineTo(160f, 280f)
                close()
                moveTo(280f, 160f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(400f)
                verticalLineToRelative(80f)
                lineTo(280f, 160f)
                close()
                moveTo(160f, 800f)
                verticalLineToRelative(-400f)
                verticalLineToRelative(400f)
                close()
            }
        }.build()

        return _Subscription!!
    }

@Suppress("ObjectPropertyName")
private var _Subscription: ImageVector? = null
