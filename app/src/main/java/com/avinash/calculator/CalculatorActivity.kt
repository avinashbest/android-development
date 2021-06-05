package com.avinash.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

//        Operands
        zero.setOnClickListener {
            appendExpression("0", true)
        }
        one.setOnClickListener {
            appendExpression("1", true)
        }
        two.setOnClickListener {
            appendExpression("2", true)
        }
        three.setOnClickListener {
            appendExpression("3", true)
        }
        four.setOnClickListener {
            appendExpression("4", true)
        }
        five.setOnClickListener {
            appendExpression("5", true)
        }
        six.setOnClickListener {
            appendExpression("6", true)
        }
        seven.setOnClickListener {
            appendExpression("7", true)
        }
        eight.setOnClickListener {
            appendExpression("8", true)
        }
        nine.setOnClickListener {
            appendExpression("9", true)
        }
        decimal.setOnClickListener {
            appendExpression(".", true)
        }

//        Operators
        plus.setOnClickListener {
            appendExpression("+", false)
        }
        minus.setOnClickListener {
            appendExpression("-", false)
        }
        multiply.setOnClickListener {
            appendExpression("*", false)
        }
        divide.setOnClickListener {
            appendExpression("/", false)
        }
        modulo.setOnClickListener {
            appendExpression("%", false)
        }

//        Change Sign
        plus_minus.setOnClickListener {
            result.text = ""
            result.hint = ""

            if (expression.text.isNotEmpty() && expression.text[0] == '-') {
                expression.text = expression.text.substring(1)
            } else {
                expression.text = "-${expression.text}"

            }
        }

//        Clearing Expression
        all_clear.setOnClickListener {
            expression.text = ""
            result.text = ""
            result.hint = ""
        }

        backspace.setOnClickListener {
            result.text = ""
            result.hint = ""
            val value = expression.text.toString()
            if (value.isNotEmpty()) {
                expression.text = value.substring(0, value.length - 1)
            }
        }

//        Calculation of Expression
        equalTo.setOnClickListener {
            try {
                val answer = ExpressionBuilder(expression.text.toString()).build().evaluate()
                result.text = answer.toString()
            } catch (e: Exception) {
                result.text = e.message
            }
        }
    }

    private fun appendExpression(value: String, clearScreen: Boolean) {
        if (result.text != "") {
            expression.text = ""
        }
        /*When value is a number*/
        if (clearScreen) {
            result.text = ""
            expression.append(value)
        } else {
            expression.append(result.text)
            expression.append(value)
            result.text = ""
        }

        result.hint = expression.text
    }
}