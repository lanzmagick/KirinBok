package app.kirinbok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.kirinbok.ui.KirinBokApp
import app.kirinbok.ui.theme.KirinBokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KirinBokTheme {
                KirinBokApp()
            }
        }
    }
}
