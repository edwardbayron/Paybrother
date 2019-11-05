package com.paybrother

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.register_procedure_fragment.*

class RegisterProcedureFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.register_procedure_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("TAG", "olol fragmentnkfdgjhlkdfhg")

        register_year.text = arguments?.getInt("year").toString()
        register_month.text = arguments?.getInt("month").toString()
        register_day.text = arguments?.getInt("day").toString()
    }
}