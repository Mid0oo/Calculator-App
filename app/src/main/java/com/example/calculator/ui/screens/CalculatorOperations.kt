package com.example.calculator.ui.screens

interface CalculatorOperations {
    fun onClear()
    fun onDelete()
    fun onNumber(number: Int)
    fun onDecimal()
    fun onOperation(operation: String)
    fun onCalculate()
}