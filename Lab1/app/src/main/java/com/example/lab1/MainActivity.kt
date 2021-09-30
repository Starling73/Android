package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            val checkedRadioButton2Id = radioGroup2.checkedRadioButtonId

            when (checkedRadioButtonId or checkedRadioButton2Id) {
                -1 -> textView.text = "Ничего не выбрано"
                else -> {
                    val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
                    val selectedRadioButton2 = findViewById<RadioButton>(checkedRadioButton2Id)
                    textView.text =
                        selectedRadioButton.text.toString() + " " + selectedRadioButton2.text.toString()
                }
            }
        }
        button2.setOnClickListener {
            textView.text = ""
        }

    }
}