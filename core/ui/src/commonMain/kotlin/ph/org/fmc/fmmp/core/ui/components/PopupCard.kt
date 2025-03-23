package ph.org.fmc.fmmp.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ph.org.fmc.fmmp.core.ui.LocalGlobalPadding
import ph.org.fmc.fmmp.core.ui.resources.Res
import ph.org.fmc.fmmp.core.ui.resources.close
import ph.org.fmc.fmmp.core.ui.verticalScrollAndDrag

@Composable
fun PopupCard(
    cardTitle: String?,
    isPopup: Boolean,
    closePopup: () -> Unit,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val fillMaxWidthFraction = if (isPopup) 0.5F else 1F

    Box(
        modifier = (if (isPopup) Modifier.padding(24.dp, 32.dp) else Modifier).padding(
            LocalGlobalPadding.current.value
        ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(defaultElevation = if (isPopup) 6.dp else 0.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (cardTitle != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(fillMaxWidthFraction).padding(16.dp, 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = if (isPopup) Arrangement.Start else Arrangement.Center
                    ) {
                        if (isPopup) {
                            IconButton(onClick = closePopup) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = stringResource(Res.string.close)
                                )
                            }
                            Spacer(Modifier.width(16.dp))
                        }
                        Text(text = cardTitle, style = MaterialTheme.typography.titleLarge)
                    }
                }

                Column(
                    modifier = Modifier.verticalScrollAndDrag(scrollState, scope),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    content()
                }
            }
        }
    }
}