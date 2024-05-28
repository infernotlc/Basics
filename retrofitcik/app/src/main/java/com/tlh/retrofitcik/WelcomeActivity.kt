package com.tlh.retrofitcik

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.tlh.retrofitcik.models.User

class WelcomeActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        shared = getSharedPreferences("customer", MODE_PRIVATE)

        val token = shared.getString("token", null)
        val stUser = shared.getString("user", null)
        stUser?.let {
            val gson = Gson()
            val user = gson.fromJson(it, User::class.java)
            Log.d("user", user.toString())
        }

        token?.let {
            if (!it.equals("")) {
                // Daha önceden token var!
            }else {
                // bu kişi ilk defa giriş yapıyor
            }
        }
        if (token == null) {

        }
    }
}