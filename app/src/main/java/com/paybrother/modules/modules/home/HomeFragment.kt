package com.paybrother.modules.modules.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.paybrother.ContactItem
import com.paybrother.ContactsAdapter
import com.paybrother.DatePickerFragment
import com.paybrother.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var year : Int = 0
    var month : Int = 0
    var day : Int = 0
    val datePickerFragment = DatePickerFragment()
    val items  = listOf(
        ContactItem("Irina", "Kosmetolog"),
        ContactItem("Tanja", "Nogti")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactsAdapter =
            ContactsAdapter(items, object : ContactsAdapter.Callback {
                override fun onItemClicked(item: ContactItem) {
                    activity?.supportFragmentManager?.let {
                        datePickerFragment.show(
                            it,
                            "datePicker"
                        )
                    }
                }
            })

        list_contacts.adapter = contactsAdapter
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent()

        if(intent.extras != null) {
            val sent = intent.extras.get("year")
            year = intent.extras.get("year") as Int
            Toast.makeText(activity, "year: " + year, Toast.LENGTH_SHORT).show()
        }
    }
}