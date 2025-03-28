package com.example.sllitsupportdesk

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AnnouncementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        // Set the content to use the announcements layout
        setContentView(R.layout.announcements)


        // Find the Next button by its ID
        val nextButton: Button = findViewById(R.id.nextButton)

        // Set an OnClickListener to transition to AnnouncementsActivity when the button is clicked
        nextButton.setOnClickListener {
            // Transition to AnnouncementsActivity
            val intent = Intent(this@AnnouncementsActivity, Alerts::class.java)
            startActivity(intent)
            finish() // Finish the current activity so the user can't go back to it
        }

    }
        // Override the onBackPressed() function to handle back press
        @SuppressLint("MissingSuperCall")
        override fun onBackPressed() {
            // Navigate to AnnouncementsActivity when the back button is pressed
            val intent = Intent(this@AnnouncementsActivity, GetStartedActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity so the user can't go back to it
        }

}