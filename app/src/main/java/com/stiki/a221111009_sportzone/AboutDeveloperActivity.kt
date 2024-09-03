package com.stiki.a221111009_sportzone

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class AboutDeveloperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_developer)

        // Jika Anda menggunakan view binding atau findViewById, pastikan elemen-elemen ini diinisialisasi dengan benar.
        val developerImage = findViewById<ImageView>(R.id.imageView2)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val nrpTextView = findViewById<TextView>(R.id.nrpTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val universityTextView = findViewById<TextView>(R.id.universityTextView)
        val majorTextView = findViewById<TextView>(R.id.majorTextView)
        val aboutTextView = findViewById<TextView>(R.id.aboutTextView)

        // Contoh penggunaan data (pastikan data yang digunakan benar-benar ada)
        nameTextView.text = "Nama: Muhammad Rafli Nurfathan"
        nrpTextView.text = "Nrp: 221-111-009"
        emailTextView.text = "Email: 221111009@mhs.ac.id"
        universityTextView.text = "Universitas: STIKI Malang"
        majorTextView.text = "Jurusan: Informatika"
        aboutTextView.text = "Tentang: Mahasiswa yang tertarik dalam pengembangan perangkat lunak dan aplikasi mobile."
    }
}