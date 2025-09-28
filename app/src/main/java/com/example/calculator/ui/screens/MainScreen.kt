package com.example.calculator.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.components.CalculatorButtons

@Composable
fun MainScreen(
    viewModel: CalculatorViewModel = hiltViewModel()

) {
    val expression by viewModel.expression.collectAsState()
    val result by viewModel.result.collectAsState()
    MainScreenContent(
        expression = expression,
        result = result,
        viewModel = viewModel
    )

}
@Composable
fun MainScreenContent(
    expression: String = "",
    result: String = "",
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainer),
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment =Alignment.CenterEnd
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = expression,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 40.sp,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
                Text(
                    text = result,
                    color = Color.Gray,
                    fontSize = 24.sp,
                    textAlign = TextAlign.End
                )

            }
        }
        CalculatorButtons(
            viewModel = viewModel
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreenContent()
}