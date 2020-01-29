package com.example.android.sqliteexample


import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    interface OnDbOpListener{
        fun dBOpPerformed( method: Int)
    }

    lateinit var onDbOpListener: OnDbOpListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.buttonAdd.setOnClickListener {
            onDbOpListener.dBOpPerformed(0)
        }

        view.buttonView.setOnClickListener {
            onDbOpListener.dBOpPerformed(1)
        }

        view.buttonUpdate.setOnClickListener {
            onDbOpListener.dBOpPerformed(2)
        }

        view.buttonDelete.setOnClickListener {
            onDbOpListener.dBOpPerformed(3)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as Activity

        try {
            onDbOpListener = activity as OnDbOpListener
        }
        catch(e : ClassCastException){
            throw ClassCastException(activity.toString() + " must implement the interface method")
        }

    }


}
