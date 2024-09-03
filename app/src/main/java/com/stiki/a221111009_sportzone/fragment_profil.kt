package com.stiki.a221111009_sportzone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.imageview.ShapeableImageView

class fragment_profil : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewInstagram: TextView = view.findViewById(R.id.textViewInstagram)
        val textViewAbout: TextView = view.findViewById(R.id.textViewAbout)
        val buttonLogout: Button = view.findViewById(R.id.buttonLogout)
        val textViewDeveloper = view.findViewById<TextView>(R.id.textViewDeveloper)

        // Textview Link Instagram
        textViewInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/mhmmdraflii._?igsh=MWE3d3RvbHg2N3czNQ==")
        }
        // Textview About
        textViewAbout.setOnClickListener {
            val intent = Intent(requireContext(), AboutActivity::class.java)
            startActivity(intent)
        }
        // Button Logout
        buttonLogout.setOnClickListener {
            val intent = Intent(requireContext(), login::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        // TextView untuk About Developer
        textViewDeveloper.setOnClickListener {
            val intent = Intent(activity, AboutDeveloperActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}