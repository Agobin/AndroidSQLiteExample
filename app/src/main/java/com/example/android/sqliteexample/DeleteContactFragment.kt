package com.example.android.sqliteexample


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_delete_contact.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.buttonDelete

/**
 * A simple [Fragment] subclass.
 */
class DeleteContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_delete_contact, container, false)

        view.buttonDelete.setOnClickListener {
            val contactContract = ContactDbHelper(context as Activity)
            val database = contactContract.writableDatabase

            val id = view.contactID.text.toString()

            contactContract.deleteContact(id.toInt(), database)

            view.contactID.setText("")
            contactContract.close()

            Toast.makeText(context, "Record deleted successfully", Toast.LENGTH_LONG).show()
        }

        return view
    }


}
