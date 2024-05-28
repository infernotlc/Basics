package com.example.bundle_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    var txtString: TextView? = null
//    var txtBoolean: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtString = findViewById(R.id.txtString)
        //       txtBoolean = findViewById(R.id.)
        val bundle = intent.extras

        txtString?.setText(bundle!!.getString("key1", "No value from MainActivity :("))
    }
}