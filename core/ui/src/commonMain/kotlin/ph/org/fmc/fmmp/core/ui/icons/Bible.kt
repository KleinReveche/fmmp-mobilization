package ph.org.fmc.fmmp.core.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Bible: ImageVector
    get() {
        if (_Bible != null) {
            return _Bible!!
        }
        _Bible = ImageVector.Builder(
            name = "Bible",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(36.99f, 34.94f)
                horizontalLineTo(48.14f)
                verticalLineTo(62.62f)
                arcToRelative(0.3f, 0.3f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.3f, 0.3f)
                horizontalLineToRelative(4.97f)
                arcToRelative(0.3f, 0.3f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.3f, -0.3f)
                verticalLineTo(34.94f)
                horizontalLineTo(64.86f)
                arcToRelative(0.29f, 0.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.29f, -0.29f)
                verticalLineToRelative(-5f)
                arcToRelative(0.29f, 0.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.29f, -0.29f)
                horizontalLineTo(53.71f)
                verticalLineTo(18.13f)
                arcToRelative(0.3f, 0.3f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.3f, -0.3f)
                horizontalLineTo(48.44f)
                arcToRelative(0.3f, 0.3f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.3f, 0.3f)
                verticalLineTo(29.36f)
                horizontalLineTo(36.99f)
                arcToRelative(0.29f, 0.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.29f, 0.29f)
                verticalLineToRelative(5f)
                arcTo(0.29f, 0.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, 36.99f, 34.94f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(74.72f, 5.17f)
                horizontalLineTo(27.31f)
                curveToRelative(-2.64f, 0f, -5.79f, 1.08f, -5.79f, 6.25f)
                verticalLineTo(78.65f)
                curveToRelative(0f, 5.16f, 3.15f, 6.25f, 5.79f, 6.25f)
                horizontalLineTo(35.96f)
                verticalLineToRelative(9.93f)
                lineToRelative(6.63f, -5.98f)
                lineToRelative(6.63f, 5.98f)
                verticalLineTo(84.9f)
                horizontalLineTo(72.46f)
                arcToRelative(3.76f, 3.76f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.76f, -3.76f)
                verticalLineTo(75.09f)
                arcToRelative(3.76f, 3.76f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.26f, -3.44f)
                verticalLineTo(8.93f)
                arcTo(3.76f, 3.76f, 0f, isMoreThanHalf = false, isPositiveArc = false, 74.72f, 5.17f)
                close()
                moveTo(33.7f, 29.65f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = true, 3.29f, -3.29f)
                horizontalLineToRelative(8.15f)
                verticalLineTo(18.13f)
                arcTo(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 48.44f, 14.83f)
                horizontalLineToRelative(4.97f)
                arcToRelative(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 3.3f, 3.3f)
                verticalLineToRelative(8.23f)
                horizontalLineToRelative(8.15f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = true, 3.29f, 3.29f)
                verticalLineToRelative(5f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.29f, 3.29f)
                horizontalLineTo(56.71f)
                verticalLineTo(62.62f)
                arcToRelative(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.3f, 3.3f)
                horizontalLineTo(48.44f)
                arcToRelative(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.3f, -3.3f)
                verticalLineTo(37.94f)
                horizontalLineTo(36.99f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.29f, -3.29f)
                close()
                moveTo(73.22f, 81.14f)
                arcToRelative(0.76f, 0.76f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.76f, 0.76f)
                horizontalLineTo(49.22f)
                verticalLineTo(79.17f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3f, 0f)
                verticalLineToRelative(8.91f)
                lineToRelative(-3.63f, -3.28f)
                lineTo(38.96f, 88.08f)
                verticalLineTo(79.17f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3f, 0f)
                verticalLineToRelative(2.73f)
                horizontalLineTo(27.31f)
                curveToRelative(-1.81f, 0f, -2.79f, -0.52f, -2.79f, -3.25f)
                curveToRelative(0f, -2.73f, 0.98f, -3.25f, 2.79f, -3.25f)
                horizontalLineTo(73.22f)
                close()
            }
        }.build()

        return _Bible!!
    }

@Suppress("ObjectPropertyName")
private var _Bible: ImageVector? = null
