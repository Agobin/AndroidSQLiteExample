package com.example.android.sqliteexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnDbOpListener {

    override fun dBOpPerformed(method: Int) {
        when(method){
            0 -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AddContactFragment()).addToBackStack(null).commit()
            1 -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ReadContactsFragment()).addToBackStack(null).commit()
            2 -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, UpdateContactFragment()).addToBackStack(null).commit()
            3 -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DeleteContactFragment()).addToBackStack(null).commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("DEBUG", "Now in the MainActivity onCreate method")

        fragment_container?.let{
            Log.i("DEBUG", "Fragment container not null")
            savedInstanceState?.let{
                return
            }

            Log.i("DEBUG", "savedInstanceState not null")
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment(), null).commit()
        }
    }

}
