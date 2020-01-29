package com.example.android.sqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ContactDbHelper(val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    init {
        Log.d("Database Operations", "Database created...")
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        //This creates the table
        sqLiteDatabase.execSQL(CREATE_TABLE)
        Log.d("Database Operations", "Table created...")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        //This upgrades the table by first dropping the existing table and then creating the upgraded table
        sqLiteDatabase.execSQL(DROP_TABLE)
        onCreate(sqLiteDatabase)
    }

    fun addContact(id: Int, name: String, email: String, database: SQLiteDatabase) {
        val contentValues = ContentValues()
        contentValues.put(ContactContract.CONTACT_ID, id)
        contentValues.put(ContactContract.NAME, name)
        contentValues.put(ContactContract.EMAIL, email)

        database.insert(ContactContract.TABLE_NAME, null, contentValues)
        Log.d("Database Operations", "One row inserted...")
    }

    fun readContacts(database: SQLiteDatabase) : Cursor{
        val projections = arrayOf<String>(ContactContract.CONTACT_ID, ContactContract.NAME, ContactContract.EMAIL)

        var cursor = database.query(ContactContract.TABLE_NAME, projections, null, null, null, null, null)

        return cursor
    }

    companion object {

        val DATABASE_NAME = "contact_db"
        val DATABASE_VERSION = 1

        val CREATE_TABLE = "create table " + ContactContract.TABLE_NAME + "(" +
                ContactContract.CONTACT_ID + " number, " + ContactContract.NAME + " text, " +
                ContactContract.EMAIL + " text);"

        val DROP_TABLE = "drop table if exists " + ContactContract.TABLE_NAME
    }

}
