package com.example.android.sqliteexample

class ContactContract {

    init {}

    //This is the database schema
    companion object ContactEntry{
        val TABLE_NAME = "contact_info"
        val CONTACT_ID = "contact_id"
        val NAME = "name"
        val EMAIL = "email"
    }

}