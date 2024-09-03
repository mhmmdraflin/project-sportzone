package com.stiki.a221111009_sportzone

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.stiki.a221111009_sportzone.databinding.ActivityDiskonDetailBinding

class DiskonDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diskon_detail)

        val imageViewDiskon = findViewById<ImageView>(R.id.imageViewDiskon)
        val textViewDiskonInfo = findViewById<TextView>(R.id.textViewDiskonInfo)
        val textViewDiskonDesk = findViewById<TextView>(R.id.textViewDiskonDesk)
        val textViewDiskonDate = findViewById<TextView>(R.id.textViewDiskonDate)

        val diskonInfo = intent.getStringExtra("DISKON_INFO")
        val diskonDate = intent.getStringExtra("DISKON_DATE")
        val diskonDescription = intent.getStringExtra("DISKON_DESC")

        // Set the received information to the views
        textViewDiskonInfo.text = diskonInfo
        textViewDiskonDesk.text = diskonDescription
        textViewDiskonDate.text = diskonDate

        // You can set the image resource or URL to the ImageView here
        // For example: imageViewDiskon.setImageResource(R.drawable.your_image)
        // If you need to load an image from URL, you might want to use a library like Glide or Picasso
    }
}