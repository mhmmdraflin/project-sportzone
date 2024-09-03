package com.stiki.a221111009_sportzone

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import java.util.*

class EditBookingActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var etNama: EditText
    private lateinit var etTanggal: EditText
    private lateinit var spLapangan: Spinner
    private lateinit var spOlahraga: Spinner
    private lateinit var spDurasi: Spinner
    private lateinit var btnUpdate: Button
    private var bookingId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_booking)

        dbHelper = DatabaseHelper(this)

        etNama = findViewById(R.id.etNama)
        etTanggal = findViewById(R.id.etTanggal)
        spLapangan = findViewById(R.id.spLapangan)
        spOlahraga = findViewById(R.id.spOlahraga)
        spDurasi = findViewById(R.id.spDurasi)
        btnUpdate = findViewById(R.id.btnUpdate)

        bookingId = intent.getIntExtra("BOOKING_ID", -1)
        val bookingNama = intent.getStringExtra("BOOKING_NAMA")
        val bookingTanggal = intent.getStringExtra("BOOKING_TANGGAL")
        val bookingLapangan = intent.getStringExtra("BOOKING_LAPANGAN")
        val bookingOlahraga = intent.getStringExtra("BOOKING_OLAHRAGA")
        val bookingDurasi = intent.getStringExtra("BOOKING_DURASI")

        etNama.setText(bookingNama)
        etTanggal.setText(bookingTanggal)

        // Inisialisasi spinner lapangan
        val lapanganArray = resources.getStringArray(R.array.lapangan_array)
        val lapanganAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lapanganArray)
        lapanganAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spLapangan.adapter = lapanganAdapter
        spLapangan.setSelection(lapanganArray.indexOf(bookingLapangan))

        // Inisialisasi spinner olahraga
        val olahragaArray = resources.getStringArray(R.array.olahraga_array)
        val olahragaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, olahragaArray)
        olahragaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spOlahraga.adapter = olahragaAdapter
        spOlahraga.setSelection(olahragaArray.indexOf(bookingOlahraga))

        // Inisialisasi spinner durasi
        val durasiArray = resources.getStringArray(R.array.durasi_array)
        val durasiAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, durasiArray)
        durasiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDurasi.adapter = durasiAdapter
        spDurasi.setSelection(durasiArray.indexOf(bookingDurasi))

        etTanggal.setOnClickListener {
            showDatePickerDialog()
        }

        btnUpdate.setOnClickListener {
            val nama = etNama.text.toString()
            val tanggal = etTanggal.text.toString()
            val lapangan = spLapangan.selectedItem.toString()
            val olahraga = spOlahraga.selectedItem.toString()
            val durasi = spDurasi.selectedItem.toString()

            // Validasi input sebelum melakukan update
            if (nama.isNotEmpty() && tanggal.isNotEmpty()) {
                dbHelper.updateBooking(bookingId, nama, tanggal, lapangan, olahraga, durasi)
                Toast.makeText(this, "Booking updated", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
            etTanggal.setText("$dayOfMonth/${monthOfYear + 1}/$year")
        }, year, month, day)
        datePickerDialog.show()
    }
}
