package com.tlh.room

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.tlh.room.configs.AppDatabase
import com.tlh.room.entities.Product
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "pro-1.db").build()
        val product = Product(null, "Tv1", "Tv detail-2", 21500.0f)
        val dao = db.productDao()

        lifecycleScope.launch {
          val arr = dao.getAll()

            for (product in arr) {
                Log.d(TAG, "onCreate: $product")
            }
            val insertStatus = dao.insert(product)
          Log.d(TAG, "$insertStatus")

      }
    }
}