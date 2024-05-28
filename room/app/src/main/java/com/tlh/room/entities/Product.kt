package com.tlh.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")// yazmazsak oto sınıfın adı olur
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pid")
    val pid: Int?,

    val title: String,
    val detail: String,
    val price: Float,

)
