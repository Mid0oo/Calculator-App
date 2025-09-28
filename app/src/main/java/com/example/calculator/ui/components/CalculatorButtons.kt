package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.calculator.ui.screens.CalculatorViewModel

@Composable
fun CalculatorButtons(
    viewModel: CalculatorViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter,

        ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                CircularButton(
                    title = "C",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onClear()}
                )
                CircularButton(
                    title = "7",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(7)}
                )
                CircularButton(
                    title = "4",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(4)}
                )
                CircularButton(
                    title = "1",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(1)}
                )
                CircularButton(
                    title = "%",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onOperation("%")}
                )

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                CircularButton(
                    title = "÷",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onOperation("÷")}
                )
                CircularButton(
                    title = "8",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(8)}
                )
                CircularButton(
                    title = "5",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(5)}
                )
                CircularButton(
                    title = "2",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(2)}
                )
                CircularButton(
                    title = "0",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(0)}
                )

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                CircularButton(
                    title = "x",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onOperation("x")}
                )
                CircularButton(
                    title = "9",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(9)}
                )
                CircularButton(
                    title = "6",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(6)}
                )
                CircularButton(
                    title = "3",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onNumber(3)}
                )
                CircularButton(
                    title = ".",
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = {viewModel.onDecimal()}
                )

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                CircularButton(
                    title = "⌫",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onDelete()}
                )
                CircularButton(
                    title = "-",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onOperation("-")}
                )
                CircularButton(
                    title = "+",
                    color = MaterialTheme.colorScheme.secondary,
                    onClick = {viewModel.onOperation("+")}
                )

                EqualButton(onClick = {viewModel.onCalculate()})

            }

        }
    }
}