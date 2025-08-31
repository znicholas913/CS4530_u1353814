package com.example.helloandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Getting the buttons from the layout.
        val welcomeButton: Button = findViewById(R.id.welcomeButton)
        val cSButton: Button = findViewById(R.id.csButton)
        val courseButton: Button = findViewById(R.id.course)
        val utesButton: Button = findViewById(R.id.utesButton)
        val basketballButton: Button = findViewById(R.id.basketballButton)

        //Setting up each button with their listener.
        setUpButton(welcomeButton)
        setUpButton(cSButton)
        setUpButton(courseButton)
        setUpButton(utesButton)
        setUpButton(basketballButton)

    }

    private fun setUpButton(button: Button){
        val buttonText = button.text.toString() // gets button text
        button.setOnClickListener {
            val intent = Intent(this, secondActivity::class.java)
            intent.putExtra("buttonText", buttonText) // passes the button text with the intent.
            startActivity(intent) // opens the second activity.
        }
    }
}