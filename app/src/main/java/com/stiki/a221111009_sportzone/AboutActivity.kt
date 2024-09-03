package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Get the TextViews and ImageView from XML
        val imageViewLogo = findViewById<ImageView>(R.id.imageViewLogo)
        val textViewAplikasi = findViewById<TextView>(R.id.textViewAplikasi)
        val textViewDesk = findViewById<TextView>(R.id.textViewDesk)
        val textViewVersiAplikasi = findViewById<TextView>(R.id.textViewVersiAplikasi)
        val textViewMadeBy = findViewById<TextView>(R.id.textViewMadeBy)

        // Set the text and image resources
        textViewAplikasi.text = "SportZone App"
        textViewDesk.text = "\"SportZone\" adalah aplikasi pemesanan lapangan yang memudahkan pengguna untuk melakukan reservasi lapangan olahraga dengan cepat dan efisien. Dengan antarmuka yang intuitif, pengguna dapat memilih jenis lapangan, tanggal, waktu mulai, dan durasi sesuai kebutuhan mereka. Aplikasi ini juga menyediakan fitur pembayaran yang terintegrasi untuk memudahkan konfirmasi dan pembayaran reservasi. Dengan SportZone, pengguna dapat dengan mudah mengelola dan melacak semua reservasi lapangan olahraga mereka dalam satu tempat.."
        textViewVersiAplikasi.text = "Versi 1.0"
        textViewMadeBy.text = "Dibuat oleh Muhammad Rafli Nurfathan"

        // Set the image resource for the logo
        imageViewLogo.setImageResource(R.drawable.bg_splash)

        // Optionally handle click events or additional logic here
    }
}
