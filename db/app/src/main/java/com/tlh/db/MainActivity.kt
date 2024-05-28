package com.tlh.db

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tlh.db.services.ContactService


class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)

        val contactService = ContactService(this)
        //  val addStatus = contactService.addContact("talha", "ben", 13, "red")
        //  Log.d(TAG, "$addStatus")

        //  val deleteStatus = contactService.deleteContact(1)
        // Log.d(TAG, "$deleteStatus")

        //  val updateStatus = contactService.updateContact(2, "sen", "evevee", 32, "black")

        // text.text = updateStatus.toString()
        //   Log.d(TAG, "$updateStatus")
        //val arr = contactService.allContact()
        //contactService.allContact()
        //for (item in arr) {
        //  Log.d(TAG, "$item")
        //    }
        /*
        val arr = contactService.searchContact("ben")
        for (item in arr) {
            Log.d("item", item.toString())
        }

         */
    val item = contactService.singleContact("talha","ben")

    }
}