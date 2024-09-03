package com.stiki.a221111009_sportzone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookingAdapter (private val context: Context, private val bookings: List<Booking>) :
    RecyclerView.Adapter<BookingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_booking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val booking = bookings[position]

        holder.nama.text = "Nama: ${booking.nama}"
        holder.tanggal.text = "Tanggal: ${booking.tanggal}"
        holder.lapangan.text = "Lapangan: ${booking.lapangan}"
        holder.olahraga.text = "Olahraga: ${booking.olahraga}"
        holder.durasi.text = "Durasi: ${booking.durasi}"
    }

    override fun getItemCount(): Int {
        return bookings.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.text_nama)
        val tanggal: TextView = itemView.findViewById(R.id.text_tanggal)
        val lapangan: TextView = itemView.findViewById(R.id.text_lapangan)
        val olahraga: TextView = itemView.findViewById(R.id.text_olahraga)
        val durasi: TextView = itemView.findViewById(R.id.text_durasi)
    }
}
