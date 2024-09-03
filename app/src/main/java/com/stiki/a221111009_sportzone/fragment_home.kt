package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stiki.a221111009_sportzone.databinding.ActivityFragmentHomeBinding
import com.stiki.a221111009_sportzone.databinding.ActivityFragmentHomeBinding.inflate
import android.content.Intent
import android.widget.Button
import androidx.fragment.app.Fragment


class fragment_home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPesan: Button = view.findViewById(R.id.btnPesan)
        val btnHistory: Button = view.findViewById(R.id.btnHistory)
        val btnGuide: Button = view.findViewById(R.id.btnGuide)

        btnPesan.setOnClickListener {
            navigateToBooking("Futsal")
        }

        btnGuide.setOnClickListener {
            startActivity(Intent(requireContext(), GuideActivity::class.java))
        }

        btnHistory.setOnClickListener {
            startActivity(Intent(requireContext(), HistoryActivity::class.java))
        }
    }

    private fun navigateToBooking(courtType: String) {
        val intent = Intent(requireContext(), BookingActivity::class.java)
        intent.putExtra("COURT_TYPE", courtType)
        startActivity(intent)
    }
}