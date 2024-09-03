package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.Fragment
import nl.joery.animatedbottombar.AnimatedBottomBar
import nl.joery.animatedbottombar.AnimatedBottomBar.OnTabSelectListener
import com.stiki.a221111009_sportzone.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val menu = intent.getStringExtra("GO_MENU")
        if (menu == "history") {
            // Load History activity
            startActivity(Intent(this, HistoryActivity::class.java))
            finish()
            return
        }

        if (savedInstanceState == null) {
            loadFragment(fragment_home())
        }

        // Handle bottom navigation item selection
        binding.animatedBottomBar.onTabSelected = { tab ->
            when (tab.id) {
                R.id.item_home -> loadFragment(fragment_home())
                R.id.item_info -> loadFragment(fragment_info())
                R.id.item_profil -> loadFragment(fragment_profil())
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}