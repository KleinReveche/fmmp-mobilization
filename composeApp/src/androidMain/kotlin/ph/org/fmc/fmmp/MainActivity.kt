package ph.org.fmc.fmmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppContext.instance = this

        setContent {
            FmmpMobilization()
        }
    }
}

internal object AppContext {
    lateinit var instance: MainActivity
}

@Preview
@Composable
fun AppAndroidPreview() {
    FmmpMobilization()
}