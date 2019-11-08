package com.paybrother.modules.modules.reservations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paybrother.R
import kotlinx.android.synthetic.main.fragment_reservations.*

class ReservationsFragment : Fragment(){

    val items  = listOf(
        ReservationItem(
            "Irina",
            "Kosmetolog",
            "October 10 2019"
        ),
        ReservationItem(
            "Tanja",
            "Nogti",
            "October 11 2019"
        ),
        ReservationItem(
            "Oksana",
            "Nogti",
            "October 12 2019"
        ),
        ReservationItem(
            "Igor",
            "Massage",
            "October 69 2019"
        ),
        ReservationItem(
            "Andrei",
            "Byxi4",
            "December 31 2019"
        ),
        ReservationItem(
            "Juri",
            "Project start",
            "November 06 2019"
        )
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reservations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reservationsAdapter = ReservationsAdapter(
            items,
            object : ReservationsAdapter.Callback {
                override fun onItemClicked(item: ReservationItem) {

                }
            })

        reservations_rv.adapter = reservationsAdapter

    }
}