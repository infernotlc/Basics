package com.tlh.trckl


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.DataBindingUtil
import com.tlh.trckl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Databinding
        binding = ActivityMainBinding.inflate(layoutInflater) //ViewBinding
        setContentView(binding.root)// Viewbinding

        val u1 = User(1, "Talha", "1234")
        binding.user = u1

           // binding.apply {
            // textView.text = "" + u1.id
            // textView2.text = u1.name
            // textView3.text = u1.password
            //button.setOnClickListener {
            //val enteredText = editText.text.toString()
            //textView.text = enteredText
        }

    }




