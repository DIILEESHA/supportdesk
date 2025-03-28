package com.example.sllitsupportdesk

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Alerts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        // Set the content to use the alerts layout
        setContentView(R.layout.alerts)

        // Find the Next button by its ID
        val nextButton: Button = findViewById(R.id.nextButton)

        // Set an OnClickListener to navigate to LoginActivity when the button is clicked
        nextButton.setOnClickListener {
            val intent = Intent(this@Alerts, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity so the user can't go back to it
        }
    }

    // Override the onBackPressed() function to handle back press
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // Navigate to AnnouncementsActivity when the back button is pressed
        val intent = Intent(this@Alerts, AnnouncementsActivity::class.java)
        startActivity(intent)
        finish() // Finish the current activity so the user can't go back to it
    }
}
