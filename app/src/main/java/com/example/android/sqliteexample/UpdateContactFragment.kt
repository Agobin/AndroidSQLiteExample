package com.example.android.sqliteexample


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_update_contact.view.*

/**
 * A simple [Fragment] subclass.
 */
class UpdateContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update_contact, container, false)

        view.buttonUpdate.setOnClickListener {

            val contactContract = ContactDbHelper(context as Activity)
            val database = contactContract.writableDatabase

            val id = view.contactID.text.toString()
            val name = view.name.text.toString()
            val email = view.email.text.toString()

            contactContract.updateContact(id.toInt(), name, email, database)

            view.contactID.setText("")
            view.name.setText("")
            view.email.setText("")

            contactContract.close()

            Toast.makeText(context, "Record updated successfully", Toast.LENGTH_LONG).show()
        }
        return view
    }


}
