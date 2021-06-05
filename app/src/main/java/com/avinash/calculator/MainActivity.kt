package com.avinash.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = counter
        val decrementButton = decrement_button
        val incrementButton = increment_button
        val reset = reset_button

        incrementButton.setOnClickListener {
            var value = Integer.parseInt(counter.text.toString())
            value += 1
            counter.text = value.toString()
        }

        decrementButton.setOnClickListener {
            var value = Integer.parseInt(counter.text.toString())
            value -= 1
            counter.text = value.toString()
        }

        reset.setOnClickListener {
            counter.text = "0"
        }
    }
}