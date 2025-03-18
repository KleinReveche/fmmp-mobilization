package ph.org.fmc.fmmp.core.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Church: ImageVector
    get() {
        if (_Church != null) {
            return _Church!!
        }
        _Church = ImageVector.Builder(
            name = "Church",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(80f, 880f)
                verticalLineToRelative(-320f)
                lineToRelative(160f, -71f)
                verticalLineToRelative(-129f)
                lineToRelative(200f, -100f)
                verticalLineToRelative(-60f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(60f)
                lineToRelative(200f, 100f)
                verticalLineToRelative(129f)
                lineToRelative(160f, 71f)
                verticalLineToRelative(320f)
                lineTo(520f, 880f)
                verticalLineToRelative(-160f)
                quadToRelative(0f, -17f, -11.5f, -28.5f)
                reflectiveQuadTo(480f, 680f)
                quadToRelative(-17f, 0f, -28.5f, 11.5f)
                reflectiveQuadTo(440f, 720f)
                verticalLineToRelative(160f)
                lineTo(80f, 880f)
                close()
                moveTo(160f, 800f)
                horizontalLineToRelative(200f)
                verticalLineToRelative(-82f)
                quadToRelative(0f, -51f, 35f, -86.5f)
                reflectiveQuadToRelative(85f, -35.5f)
                quadToRelative(50f, 0f, 85f, 35.5f)
                reflectiveQuadToRelative(35f, 86.5f)
                verticalLineToRelative(82f)
                horizontalLineToRelative(200f)
                verticalLineToRelative(-192f)
                lineToRelative(-160f, -72f)
                verticalLineToRelative(-134f)
                lineToRelative(-160f, -82f)
                lineToRelative(-160f, 82f)
                verticalLineToRelative(134f)
                lineToRelative(-160f, 72f)
                verticalLineToRelative(192f)
                close()
                moveTo(480f, 540f)
                quadToRelative(25f, 0f, 42.5f, -17.5f)
                reflectiveQuadTo(540f, 480f)
                quadToRelative(0f, -25f, -17.5f, -42.5f)
                reflectiveQuadTo(480f, 420f)
                quadToRelative(-25f, 0f, -42.5f, 17.5f)
                reflectiveQuadTo(420f, 480f)
                quadToRelative(0f, 25f, 17.5f, 42.5f)
                reflectiveQuadTo(480f, 540f)
                close()
                moveTo(480f, 560f)
                close()
            }
        }.build()

        return _Church!!
    }

@Suppress("ObjectPropertyName")
private var _Church: ImageVector? = null
