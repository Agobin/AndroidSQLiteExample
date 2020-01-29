package com.example.android.sqliteexample


import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_contact.view.*

/**
 * A simple [Fragment] subclass.
 */
class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_contact, container, false)



        view.buttonSave.setOnClickListener {
            val id = view.contactID.text.toString()
            val name = view.name.text.toString()
            val email = view.email.text.toString()

            var contactDbHelper: ContactDbHelper = ContactDbHelper(context as Activity)

            //Do this on a different thread because database operation might take long
            var database : SQLiteDatabase = contactDbHelper.writableDatabase

            //Adding data to table now
            contactDbHelper.addContact(id.toInt(), name, email, database)
            contactDbHelper.close()


            view.contactID.setText("")
            view.name.setText("")
            view.email.setText("")

            Toast.makeText(context, "New database record added successfully", Toast.LENGTH_SHORT).show()

        }

        return view
    }


}
