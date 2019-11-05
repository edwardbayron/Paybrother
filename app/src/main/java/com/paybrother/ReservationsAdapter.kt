package com.paybrother

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationsAdapter(var items: List<ReservationItem>, val callback: ReservationsAdapter.Callback) : RecyclerView.Adapter<ReservationsAdapter.ReservationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReservationsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_reservations, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ReservationsAdapter.ReservationsViewHolder, position: Int){
        holder.bind(items[position])
    }

    inner class ReservationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val firstName = itemView.findViewById<TextView>(R.id.reservations_firstName)
        private val lastName = itemView.findViewById<TextView>(R.id.reservations_lastName)
        private val date = itemView.findViewById<TextView>(R.id.date)

        fun bind(item: ReservationItem){
            firstName.text = item.firstName
            lastName.text = item.lastName
            date.text = item.date

            itemView.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback{
        fun onItemClicked(item: ReservationItem)
    }

}