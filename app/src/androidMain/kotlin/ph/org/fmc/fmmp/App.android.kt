package ph.org.fmc.fmmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ph.org.fmc.fmmp.core.ui.platform.AppContext

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppContext.instance = this
        setContent { FmmpMobilization() }
    }
}

@Preview
@Composable
fun AppPreview() {
    FmmpMobilization()
}
