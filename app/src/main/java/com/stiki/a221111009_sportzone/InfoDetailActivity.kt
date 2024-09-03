package com.stiki.a221111009_sportzone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_detail)

        val imageViewTournament = findViewById<ImageView>(R.id.imageViewTournament)
        val textViewTournamentInfo = findViewById<TextView>(R.id.textViewTournamentInfo)
        val textViewTournamentDate = findViewById<TextView>(R.id.textViewTournamentDate)
        val textViewDesk = findViewById<TextView>(R.id.textViewDesk)
        val textViewLink = findViewById<TextView>(R.id.textViewLink)

        val tournamentInfo = intent.getStringExtra("TOURNAMENT_INFO")
        val tournamentDate = intent.getStringExtra("TOURNAMENT_DATE")
        val tournamentDescription = intent.getStringExtra("TOURNAMENT_DESC")
        val tournamentLink = intent.getStringExtra("TOURNAMENT_LINK")

        // Set the received information to the views
        textViewTournamentInfo.text = tournamentInfo
        textViewTournamentDate.text = tournamentDate
        textViewDesk.text = tournamentDescription

        textViewLink.text = "Informasi selengkapnya"
        textViewLink.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tournamentLink))
            startActivity(browserIntent)
        }

        // You can set the image resource or URL to the ImageView here
        // For example: imageViewTournament.setImageResource(R.drawable.your_image)
        // If you need to load an image from URL, you might want to use a library like Glide or Picasso
    }
}
