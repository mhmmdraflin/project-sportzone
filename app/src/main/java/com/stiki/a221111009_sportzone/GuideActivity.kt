package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.stiki.a221111009_sportzone.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load images using Glide
        Glide.with(this)
            .load(R.drawable.login)
            .into(binding.imageLogin)

        Glide.with(this)
            .load(R.drawable.register)
            .into(binding.imageRegister)

        Glide.with(this)
            .load(R.drawable.booking)
            .into(binding.imageBooking)

        Glide.with(this)
            .load(R.drawable.history)
            .into(binding.imageHistory)

        Glide.with(this)
            .load(R.drawable.edit)
            .into(binding.imageEdit)

        Glide.with(this)
            .load(R.drawable.cancel)
            .into(binding.imageCancel)

        Glide.with(this)
            .load(R.drawable.fragment_info)
            .into(binding.imageInfo)

        Glide.with(this)
            .load(R.drawable.fragment_profil)
            .into(binding.imageProfil)

    }
}
