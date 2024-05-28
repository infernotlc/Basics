package com.tlh.db.services

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.tlh.db.configs.DB
import com.tlh.db.models.Contact

class ContactService(context: Context) : DB(context) {

    fun addContact(name: String, surname: String, age: Int, color: String): Long {

        val db = this.writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("age", age)
        values.put("color", color)


        val effectRow = db.insert("contacts", null, values)
        //     db.close() // Closing database connection
        return effectRow
    }


    fun deleteContact(cid: Int): Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete("contacts", "cid=$cid", null)
        //     db.close()
        return deleteStatus
    }

    fun updateContact(cid: Int, name: String, surname: String, age: Int, color: String): Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("age", age)
        values.put("color", color)

        val status = db.update("contacts", values, "cid=$cid", null)

        //  db.close()

        return status
    }

    @SuppressLint("Recycle")
    fun allContact(): List<Contact> {
        val db = this.readableDatabase
        val arr = mutableListOf<Contact>()
        val query = "SELECT * FROM contacts"
        //val cursor1 = db.query("contacts", null, null, null, null, null, null)
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val cid = cursor.getInt(0)
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val age = cursor.getInt(3)
            val color = cursor.getString(4)
            val c = Contact(cid, name, surname, age, color)
            arr.add(c)
            //     val nameSurname = name + "" + surname
            //     val builder = StringBuilder()
            //     builder.append(cid)
            //     builder.append(name)
            //     builder.append(surname)
            //     builder.append(age)
            //     builder.append(color)
            //  Log.d(TAG, "allContact: $cid $name $surname $age $color ")
        }
        return arr
    }

    fun searchContact(q: String): List<Contact> {
        val db = this.readableDatabase
        val arr = mutableListOf<Contact>()
        val query = "SELECT * FROM contacts WHERE name LIKE '%$q%' OR surname LIKE '%$q%'"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val cid = cursor.getInt(0)
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val age = cursor.getInt(3)
            val color = cursor.getString(4)
            val c = Contact(cid, name, surname, age, color)
            arr.add(c)

        }
        return arr
    }

    fun singleContact(name: String, surname: String): Contact? {
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM contacts WHERE name = ? AND surname =? ", arrayOf(name,surname))
        if(cursor.moveToNext()){
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val c= Contact(name,surname)
           db.close()
            return c
        }
        db.close()
        return null
    }
}
