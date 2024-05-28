package com.tlh.retrofitcik

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.tlh.retrofitcik.configs.ApiClient
import com.tlh.retrofitcik.models.User
import com.tlh.retrofitcik.models.UserLogin
import com.tlh.retrofitcik.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var shared: SharedPreferences
    lateinit var editor: Editor

    lateinit var iDummyService: IDummyService
    lateinit var txtUserName: TextView
    lateinit var txtName: EditText
    lateinit var txtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtUserName = findViewById(R.id.textView)
        txtName = findViewById(R.id.txtName)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.txtButton)

        shared = getSharedPreferences("customer", MODE_PRIVATE)
        editor = shared.edit()

        iDummyService = ApiClient.getClient().create(IDummyService::class.java)

        btnLogin.setOnClickListener {
            val name = txtName.text.toString()
            val password = txtPassword.text.toString()
            val userLogin = UserLogin(name, password)
            iDummyService.userLogin(userLogin).enqueue(object: Callback<User> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<User>, res: Response<User>) {
                    // servis işlemi başarılı
                    val dt = res.body()
                    dt?.let {
                        val gson = Gson()
                        val stUser = gson.toJson(it)
                        txtUserName.setText("${it.firstName} ${it.lastName}")
                        editor.putString("token", it.token)
                        editor.putString("name", "${it.firstName} ${it.lastName}" )
                        editor.putString("user", stUser)
                        editor.commit()
                    }
                }
                override fun onFailure(call: Call<User>, th: Throwable) {
                    // işlem sırasında bir hata oluştu!
                    Log.d("Login Error", "onFailure: " + th.message)
                }
            })
        }

    }
}