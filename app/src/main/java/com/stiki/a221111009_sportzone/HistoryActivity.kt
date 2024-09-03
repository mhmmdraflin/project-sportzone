package com.stiki.a221111009_sportzone

import android.database.Cursor
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class HistoryActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        dbHelper = DatabaseHelper(this)
        listView = findViewById(R.id.listViewHistory)

        loadBookings()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, id ->
            val cursor = listView.adapter.getItem(position) as Cursor
            val bookingId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
            val bookingNama = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAMA))
            val bookingTanggal = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TANGGAL))
            val bookingLapangan = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_LAPANGAN))
            val bookingOlahraga = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_OLAHRAGA))
            val bookingDurasi = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DURASI))

            showOptionsDialog(bookingId, bookingNama, bookingTanggal, bookingLapangan, bookingOlahraga, bookingDurasi)
        }
    }

    private fun loadBookings() {
        val cursor = dbHelper.getAllBookings()
        val from = arrayOf(DatabaseHelper.COLUMN_NAMA, DatabaseHelper.COLUMN_TANGGAL, DatabaseHelper.COLUMN_LAPANGAN)
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 0)
        listView.adapter = adapter
    }

    private fun showOptionsDialog(id: Int, nama: String, tanggal: String, lapangan: String, olahraga: String, durasi: String) {
        val options = arrayOf("Detail Data", "Update", "Hapus Data")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose an option")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> showDetailDialog(nama, tanggal, lapangan, olahraga, durasi)
                1 -> {
                    val intent = Intent(this, EditBookingActivity::class.java)
                    intent.putExtra("BOOKING_ID", id)
                    intent.putExtra("BOOKING_NAMA", nama)
                    intent.putExtra("BOOKING_TANGGAL", tanggal)
                    intent.putExtra("BOOKING_LAPANGAN", lapangan)
                    intent.putExtra("BOOKING_OLAHRAGA", olahraga)
                    intent.putExtra("BOOKING_DURASI", durasi)
                    startActivity(intent)
                }
                2 -> deleteBooking(id)
            }
        }
        builder.show()
    }

    private fun showDetailDialog(nama: String, tanggal: String, lapangan: String, olahraga: String, durasi: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Booking Details")
        builder.setMessage("Nama: $nama\nTanggal: $tanggal\nLapangan: $lapangan\nOlahraga: $olahraga\nDurasi: $durasi")
        builder.setPositiveButton("OK", null)
        builder.show()
    }

    private fun deleteBooking(id: Int) {
        dbHelper.deleteBooking(id)
        loadBookings()
        Toast.makeText(this, "Booking deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        loadBookings()
    }
}
