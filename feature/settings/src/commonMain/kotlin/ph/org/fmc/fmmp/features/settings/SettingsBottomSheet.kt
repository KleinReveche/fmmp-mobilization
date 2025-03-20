package ph.org.fmc.fmmp.features.settings

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsBottomSheet(settingsData: SettingsData) {
    ModalBottomSheet(
        onDismissRequest = settingsData.closeSettings,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Settings(settingsData, false)
    }
}