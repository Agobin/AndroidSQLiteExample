package com.example.android.sqliteexample


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_read_contacts.view.*

/**
 * A simple [Fragment] subclass.
 */
class ReadContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_read_contacts, container, false)

        val contactDbHelper = ContactDbHelper(context as Activity)
        val sqliteDatabase = contactDbHelper.readableDatabase

        val cursor = contactDbHelper.readContacts(sqliteDatabase)

        var info = ""

        while(cursor.moveToNext()){
            val id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.CONTACT_ID)))
            val name = cursor.getString(cursor.getColumnIndex(ContactContract.NAME))
            val email = cursor.getString(cursor.getColumnIndex(ContactContract.EMAIL))

            info += "ID: $id, Name: $name, Email: $email\n\n"

        }

        view.displayTxt.setText(info)
        contactDbHelper.close()
        return view
    }


}
