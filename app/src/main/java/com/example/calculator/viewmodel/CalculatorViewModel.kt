package com.example.calculator.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculator.domain.CalculatorOperations
import com.notkamui.keval.Keval
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor()
    : ViewModel(), CalculatorOperations {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    val operations = listOf("+", "-", "x", "÷")

    override fun onClear() {
        _expression.value = ""
        _result.value = ""
    }

    override fun onDelete() {
        if (_expression.value.isNotEmpty()) {
            _expression.value = _expression.value.dropLast(1)
            evaluate()
        }
    }

    override fun onNumber(number: Int) {
        if (_expression.value.isEmpty() || _expression.value.last().toString() in operations) {
            if (number == 0) {
                _expression.value += "0"
            }
            else {
                _expression.value += number.toString()
            }
        }
        else {
            val lastNumber = _expression.value.split(Regex("[+\\-x÷]")).last()
            if (lastNumber =="0") {
                _expression.value = _expression.value.dropLast(1) + number.toString()
            }
            else {
                _expression.value += number.toString()
            }
        }
        evaluate()
    }

    override fun onDecimal() {
        val lastNumber = _expression.value.split(Regex("[+\\-x÷]")).last()
        if (!lastNumber.contains('.')) {
            _expression.value += '.'
            evaluate()
        }
    }

    override fun onOperation(operation: String) {
        if (_expression.value.isEmpty()) {
            if (operation == "-") {
                _expression.value = operation
            }
            return
        }
        if (_expression.value.isNotEmpty()){
            val lastChar = _expression.value.last().toString()
            val secondLast = _expression.value.getOrNull(_expression.value.length - 2)?.toString()

            if (lastChar in operations) {
                if ((secondLast != null && secondLast in operations)){
                    _expression.value = _expression.value.dropLast(2) + operation
                }
                else {
                    if (operation == "-" && lastChar != "-") {
                        _expression.value += operation
                    }
                    _expression.value = _expression.value.dropLast(1) + operation
                }
            } else {
                _expression.value += operation
            }
        }

    }
    override fun onCalculate() {
        if (_expression.value.isEmpty()|| _expression.value.last().toString() in operations) {
            return
        }
        else {
            _expression.value = _result.value
            _result.value = ""
        }
    }
    private fun evaluate(){
        if (_expression.value.isBlank()) {
            _result.value = ""
            return
        }
        var parsed = _expression.value
            .replace("x", "*")
            .replace("÷", "/")

        if (parsed.endsWith(".")) {
            parsed += "0"
        }
        if (parsed.last().toString() in operations) {
            _result.value
            return
        }

        parsed = parsed.replace(Regex("""\.\+"""), ".0+")
            .replace(Regex("""\.-"""), ".0-")
            .replace(Regex("""\.\*"""), ".0*")
            .replace(Regex("""\./"""), ".0/")

        try{
            val evalResult = Keval.eval(parsed)
            if (evalResult % 1 == 0.0) {
                _result.value = evalResult.toInt().toString()
            } else {
                _result.value = evalResult.toString()
            }
        } catch (e: Exception){

            _result.value = "Error"

        }
    }
}