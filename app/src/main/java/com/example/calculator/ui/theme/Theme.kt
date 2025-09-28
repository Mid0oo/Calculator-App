package com.example.calculator.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    surfaceContainer = DarkScreenBackground,
    primary = DarkButtonBlue,
    secondary = DarkEqualBlue,
    background = DarkCalculatorBackground,
    surface = DarkButtonBackground,
    onPrimary = DarkTextWhite,
    onBackground = DarkTextWhite
)

private val LightColorScheme = lightColorScheme(
    surfaceContainer = LightScreenBackground,
    primary = LightButtonBlue,
    secondary = LightEqualBlue,
    background = LightCalculatorBackground,
    surface = LightButtonBackground,
    onPrimary = LightTextBlack,
    onBackground = LightTextBlack
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}