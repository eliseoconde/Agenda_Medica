package com.example.agendamedica.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF1F6E3F),
    secondary = androidx.compose.ui.graphics.Color(0xFF6CA76C),
    tertiary = androidx.compose.ui.graphics.Color(0xFFD4A574),
)

private val DarkColors = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF1F6E3F),
    secondary = androidx.compose.ui.graphics.Color(0xFF6CA76C),
    tertiary = androidx.compose.ui.graphics.Color(0xFFD4A574),
)

@Composable
fun AgendaMedicaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
