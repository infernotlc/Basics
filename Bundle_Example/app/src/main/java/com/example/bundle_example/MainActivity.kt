package com.example.bundle_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var btnPassBundles: Button? = null
    var btnNoPassBundles: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPassBundles = findViewById(R.id.btnPassBundles)
        btnNoPassBundles = findViewById(R.id.btnNoPassBundle)

        btnPassBundles?.setOnClickListener(this)
        btnNoPassBundles?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnPassBundles -> {
                val bundle = Bundle()
                bundle.putString("key1", "Passing Bundle From Main Activity to 2nd Activity")
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            R.id.btnNoPassBundle -> {
                val bundle = Bundle()
                bundle.putString("key1", "Not passing Bundle From Main Activity")
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            }

        }
    }
}