package ph.org.fmc.fmmp.core.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FmcLogo: ImageVector
    get() {
        if (_FmcLogo != null) {
            return _FmcLogo!!
        }
        _FmcLogo = ImageVector.Builder(
            name = "FmcLogo",
            defaultWidth = 564.dp,
            defaultHeight = 1189.dp,
            viewportWidth = 564f,
            viewportHeight = 1189f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFF47C3C)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(349f, 1.3f)
                curveToRelative(0f, 0.2f, 0.8f, 2.8f, 1.9f, 5.8f)
                curveToRelative(6.1f, 17.7f, 6.8f, 47.7f, 1.7f, 71.8f)
                curveToRelative(-14.3f, 67.4f, -62.7f, 139.7f, -147.1f, 219.6f)
                curveToRelative(-54.3f, 51.4f, -85.8f, 85.5f, -115.5f, 125f)
                curveTo(38.1f, 492.6f, 11.6f, 554.8f, 3f, 628f)
                curveToRelative(-3.4f, 29f, -3f, 70.7f, 1f, 106f)
                curveToRelative(2f, 17.8f, 5.7f, 42f, 6.5f, 42.8f)
                curveToRelative(0.2f, 0.2f, 0.8f, -0.6f, 1.3f, -1.9f)
                curveToRelative(14.8f, -41.2f, 34.4f, -76.6f, 64.6f, -116.6f)
                curveToRelative(31.9f, -42.3f, 65.8f, -77.5f, 121.6f, -126.3f)
                curveToRelative(44.2f, -38.7f, 62.2f, -55.4f, 87.5f, -81.1f)
                curveToRelative(38.4f, -39f, 63.5f, -70.6f, 84.8f, -106.6f)
                curveToRelative(43.4f, -73.5f, 56.8f, -148f, 40.1f, -223f)
                curveToRelative(-7f, -31.4f, -22.4f, -67.2f, -40.7f, -94.7f)
                curveTo(359.2f, 10.8f, 349f, -1.6f, 349f, 1.3f)
            }
            path(
                fill = SolidColor(Color(0xFF5C8CB4)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(463f, 249.8f)
                curveToRelative(0f, 31.8f, -25.9f, 96.1f, -59.7f, 148.1f)
                curveToRelative(-25.5f, 39.2f, -52.8f, 68f, -121.8f, 128.5f)
                curveToRelative(-69.8f, 61.2f, -106.3f, 96.7f, -146f, 142.1f)
                curveToRelative(-19.6f, 22.4f, -46.9f, 56f, -56.3f, 69.4f)
                curveTo(53.2f, 774.8f, 36.4f, 816.5f, 29.4f, 861f)
                curveToRelative(-2.5f, 16.1f, -3.1f, 56.8f, -1f, 74.5f)
                curveToRelative(14.3f, 123.4f, 105.9f, 223.5f, 227.1f, 248f)
                curveToRelative(27.4f, 5.5f, 63f, 7.1f, 89.9f, 4f)
                curveToRelative(87.5f, -10.2f, 164.3f, -59.1f, 211.1f, -134.5f)
                curveToRelative(4.2f, -6.7f, 7.3f, -12.4f, 7f, -12.7f)
                reflectiveCurveToRelative(-2.7f, 1.3f, -5.3f, 3.5f)
                curveToRelative(-11.9f, 10f, -35.2f, 22.4f, -70.3f, 37.5f)
                curveToRelative(-39.4f, 16.9f, -70.6f, 23.7f, -108f, 23.7f)
                curveToRelative(-24.9f, -0f, -38.7f, -2.4f, -70.5f, -12f)
                curveToRelative(-25.1f, -7.6f, -37f, -13.6f, -68f, -34.4f)
                curveToRelative(-25.5f, -17.1f, -39f, -32.2f, -61.4f, -68.9f)
                curveToRelative(-15.1f, -24.7f, -21.2f, -33f, -32f, -43.8f)
                curveToRelative(-9.6f, -9.5f, -20.3f, -16.6f, -30.1f, -20.1f)
                curveToRelative(-5.5f, -1.9f, -8.5f, -2.3f, -19.5f, -2.3f)
                curveToRelative(-12.9f, -0f, -13f, -0f, -18.9f, 3.3f)
                curveToRelative(-3.2f, 1.8f, -6f, 3.1f, -6.2f, 2.9f)
                curveToRelative(-0.5f, -0.5f, 7.4f, -11.4f, 15.1f, -20.7f)
                curveToRelative(8.4f, -10.3f, 9.1f, -11.5f, 12.5f, -21.4f)
                curveToRelative(1.6f, -4.8f, 3.8f, -10.2f, 4.9f, -11.9f)
                curveToRelative(9.7f, -15.7f, 34.2f, -23f, 56.3f, -16.9f)
                curveToRelative(10.8f, 3f, 28.1f, 10.6f, 51.7f, 22.7f)
                curveToRelative(11.2f, 5.7f, 21.2f, 10.4f, 22.3f, 10.4f)
                curveToRelative(2.9f, 0f, 4.3f, -4.4f, 7.8f, -25.5f)
                curveToRelative(7.5f, -44.7f, 18.6f, -74f, 39.1f, -102.7f)
                curveToRelative(11.6f, -16.2f, 23.2f, -28.2f, 45.5f, -46.8f)
                curveToRelative(81.5f, -68.1f, 129.1f, -136.8f, 151.9f, -219.1f)
                curveToRelative(14f, -50.7f, 15.8f, -109.3f, 5f, -169.9f)
                curveToRelative(-3.1f, -17.4f, -19.9f, -83.8f, -21.7f, -85.6f)
                curveToRelative(-0.4f, -0.4f, -0.7f, 2.9f, -0.7f, 7.4f)
            }
        }.build()

        return _FmcLogo!!
    }

@Suppress("ObjectPropertyName")
private var _FmcLogo: ImageVector? = null
