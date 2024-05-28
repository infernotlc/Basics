package com.tlh.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tlh.room.entities.Product

@Dao
interface ProductDao {

    @Insert
    fun insert(product: Product): Long

    @Delete
    fun delete(product: Product): Int

    @Update
    fun update(product: Product): Int

    @Query("SELECT * FROM Product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM Product WHERE pid = :pid")
    fun findById(pid: Int ) : Product?

    @Query("SELECT * FROM Product WHERE title = :title")
    fun searchTitle(title: String): List<Product>






}