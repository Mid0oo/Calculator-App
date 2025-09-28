package com.example.calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EqualButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 160.dp)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.secondary)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text("=", color = Color.White, fontSize = 28.sp)
    }
}
