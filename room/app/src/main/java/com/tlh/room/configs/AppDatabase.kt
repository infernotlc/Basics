package com.tlh.room.configs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlh.room.dao.ProductDao
import com.tlh.room.entities.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase()  {

    abstract fun productDao(): ProductDao

}

