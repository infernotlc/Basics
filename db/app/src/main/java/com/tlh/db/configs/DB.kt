package com.tlh.db.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(context: Context) : SQLiteOpenHelper(context, DBNAME, null, VERSION) {

    companion object {
        private const val DBNAME = "project.db"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contacts = "CREATE TABLE \"contacts\" (\n" +
                "\t\"cid\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"surname\"\tTEXT,\n" +
                "\t\"age\"\tINTEGER,\n" +
                "\t\"color\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"cid\" AUTOINCREMENT)\n" +
                ");"

        db?.execSQL(contacts)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val contactDropSql = "DROP TABLE IF EXISTS contacts"
        db?.execSQL(contactDropSql)
        onCreate(db)
    }
}
