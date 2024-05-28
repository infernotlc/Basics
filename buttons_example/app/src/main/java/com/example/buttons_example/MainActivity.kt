package com.example.buttons_example

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_button)
        //buton idsini bir değişkende depola
        //   val button = findViewById<Button>(R.id.button)
        //butona basıldığında ne olacağını seç tabi null değilse
        //      button?.setOnClickListener() {
        //      Toast.makeText(this@MainActivity, R.string.message, Toast.LENGTH_LONG).show()
//assign the variables
        val submitButton = findViewById<Button>(R.id.submit_button)
        val clearButton = findViewById<Button>(R.id.clear_text)
        val radioGroup = findViewById<RadioGroup>(R.id.groupradio)
//clear first
        radioGroup.clearCheck()
//each radiobutton text assigned in a variable and send to a toast message to show

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
        }
        submitButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(
                    this@MainActivity,
                    "No answer has been selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val radioButton = findViewById<RadioButton>(selectedId)
                Toast.makeText(
                    this@MainActivity,
                    radioButton.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        clearButton.setOnClickListener {
            radioGroup.clearCheck()
        }
    }

}