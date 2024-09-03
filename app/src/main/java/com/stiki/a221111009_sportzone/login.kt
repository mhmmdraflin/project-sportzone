package com.stiki.a221111009_sportzone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.annotation.SuppressLint
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class login : AppCompatActivity() {
    private lateinit var dbHelper: LoginDatabaseHelper
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        dbHelper = LoginDatabaseHelper(this)
        usernameEditText = findViewById(R.id.etEmail)
        passwordEditText = findViewById(R.id.etPassword)
        val loginButton: Button = findViewById(R.id.btnLogin)
        val registerButton: Button = findViewById(R.id.registerButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInput(username, password)) {
                if (dbHelper.loginUser(username, password)) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}