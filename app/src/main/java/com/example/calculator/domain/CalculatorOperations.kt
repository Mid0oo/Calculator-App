package com.example.calculator.domain

interface CalculatorOperations {
    fun onClear()
    fun onDelete()
    fun onNumber(number: Int)
    fun onDecimal()
    fun onOperation(operation: String)
    fun onCalculate()
}