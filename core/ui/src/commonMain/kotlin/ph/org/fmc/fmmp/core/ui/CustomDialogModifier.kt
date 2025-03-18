package ph.org.fmc.fmmp.core.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

enum class CustomDialogPosition {
    BOTTOM, TOP, TOP_RIGHT
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val horizontalPadding = (constraints.maxWidth * 0.02f).toInt().coerceAtLeast(8)
    val verticalPadding = (constraints.maxHeight * 0.02f).toInt().coerceAtLeast(8)

    layout(constraints.maxWidth, constraints.maxHeight) {
        when (pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height, 10f)
            }

            CustomDialogPosition.TOP -> {
                placeable.place(0, 0, 10f)
            }

            CustomDialogPosition.TOP_RIGHT -> {
                placeable.place(
                    constraints.maxWidth - placeable.width - horizontalPadding,
                    verticalPadding,
                    10f
                )
            }
        }
    }
}