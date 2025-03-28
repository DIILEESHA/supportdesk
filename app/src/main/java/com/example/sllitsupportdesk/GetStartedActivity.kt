package com.example.sllitsupportdesk

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class GetStartedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the ActionBar
        supportActionBar?.hide()

        // Set the content to use get_started.xml layout
        setContentView(R.layout.getstarted)

        // Find the Next button by its ID
        val nextButton: Button = findViewById(R.id.nextButton)

        // Set an OnClickListener to transition to AnnouncementsActivity when the button is clicked
        nextButton.setOnClickListener {
            val intent = Intent(this@GetStartedActivity, AnnouncementsActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity so the user can't go back to it
        }
    }

    // Handle back button press with a confirmation dialog
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit App")
        builder.setMessage("Are you sure you want to exit?")

        // Yes button - close the app
        builder.setPositiveButton("Yes") { _, _ ->
            finishAffinity() // Close all activities
        }

        // No button - dismiss the dialog
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        // Show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }
}
