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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.DarkButtonBlue

@Composable
fun CircularButton(
    title: String,
    color: Color = MaterialTheme.colorScheme.surface,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .size(72.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape
            )
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.surface)
            .clickable{onClick()},
        contentAlignment = Alignment.Center
    ){
        Text(
            text = title,
            color = color,
            fontSize = 30.sp,
        )
    }
}
@Preview()
@Composable
fun CircularButtonPreview(){
    CircularButton(
        title = "+",
        color = DarkButtonBlue,
        onClick = {}
    )
}