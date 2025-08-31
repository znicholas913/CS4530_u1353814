package com.example.helloandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val receivedText = intent.getStringExtra("buttonText") // Text from the clicked button.
        val myTextView: TextView = findViewById(R.id.secondText) // The text view
        myTextView.text = receivedText // Setting the text view to the received text.

        //Button to take you have to the main activity.
        val myButton: Button = findViewById(R.id.backButton)
        myButton.setOnClickListener {
            finish() // closes this activity and brings you back to the main activity.
        }
    }
}