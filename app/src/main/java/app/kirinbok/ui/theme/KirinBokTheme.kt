package app.kirinbok.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Color(0xFFD5B8FF),
    onPrimary = Color(0xFF32115E),
    secondary = Color(0xFFB8C7FF),
    background = Color(0xFF111318),
    surface = Color(0xFF191B22),
    surfaceVariant = Color(0xFF292C35),
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF6842A5),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF52659A),
    background = Color(0xFFF8F6FC),
    surface = Color(0xFFFFFBFF),
    surfaceVariant = Color(0xFFEAE5F0),
)

@Composable
fun KirinBokTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography(),
        content = content,
    )
}
