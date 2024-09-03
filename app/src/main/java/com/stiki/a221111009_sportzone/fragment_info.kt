package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import android.widget.LinearLayout
import android.widget.TextView

class fragment_info: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment_info, container, false)

        val textViewInfo = view.findViewById<LinearLayout>(R.id.txt1)
        textViewInfo.setOnClickListener {
            val intent = Intent(activity, InfoDetailActivity::class.java)
            intent.putExtra("TOURNAMENT_INFO", "Event Turnamen")
            intent.putExtra("TOURNAMENT_DESC", "Turnamen antar Siswa SMA")
            intent.putExtra("TOURNAMENT_DATE", "29 Desember 2023")
            intent.putExtra("TOURNAMENT_LINK", "https://skor.id/post/daftar-berbagai-turnamen-futsal-yang-bergengsi-di-indonesia")
            startActivity(intent)
        }
        val textViewInfoDiskon = view.findViewById<LinearLayout>(R.id.txt2)
        textViewInfoDiskon.setOnClickListener {
            val intent = Intent(activity, DiskonDetailActivity::class.java)
            intent.putExtra("DISKON_INFO", "Diskon Lapangan")
            intent.putExtra("DISKON_DATE", "Diskon di hari spesial")
            intent.putExtra("DISKON_DESC", "29 Desember 2023")
            startActivity(intent)
        }

        return view
    }
}

