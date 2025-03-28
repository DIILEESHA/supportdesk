package com.example.sllitsupportdesk

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sllitsupportdesk.R.*
import com.example.sllitsupportdesk.R.id.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(layout.register)

        // Find the UI elements by their IDs
        val fullName: EditText = findViewById(R.id.editTextFullName)
        val email: EditText = findViewById(R.id.editTextEmail)
        val userName: EditText = findViewById(R.id.editTextUserName)
        val password: EditText = findViewById(R.id.editTextPassword)
        val confirmPassword: EditText = findViewById(R.id.editTextConfirmPassword)
        val termsAndConditions: CheckBox = findViewById(R.id.checkBoxTerms)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginLink: TextView = findViewById(R.id.loginLink)


        // Set an OnClickListener to navigate to LoginActivity
        loginLink.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener to handle the Register button
        registerButton.setOnClickListener {
            // Get the values from the EditText fields
            val fullNameText = fullName.text.toString()
            val emailText = email.text.toString()
            val userNameText = userName.text.toString()
            val passwordText = password.text.toString()
            val confirmPasswordText = confirmPassword.text.toString()

            // Check if all fields are filled
            if (fullNameText.isEmpty() || emailText.isEmpty() || userNameText.isEmpty() ||
                passwordText.isEmpty() || confirmPasswordText.isEmpty()) {

                // Show a toast message if any field is empty
                Toast.makeText(this@SignUpActivity, "All fields are required!", Toast.LENGTH_SHORT).show()
            } else if (passwordText != confirmPasswordText) {
                // Check if the passwords match
                Toast.makeText(this@SignUpActivity, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            } else if (!termsAndConditions.isChecked) {
                // Check if the terms and conditions checkbox is checked
                Toast.makeText(this@SignUpActivity, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                // If all fields are filled correctly, redirect to LoginActivity
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish() // Close the SignUpActivity
            }
        }

        // Simulate filling the form with dummy details (for testing)
        // Uncomment this part for dummy data entry (only for testing purposes).
        // This auto-fills the fields with predefined dummy data.
        val isDummyData = false // Change this to true to use dummy data
        if (isDummyData) {
            fullName.setText("John Doe")
            email.setText("john.doe@example.com")
            userName.setText("john_doe")
            password.setText("password123")
            confirmPassword.setText("password123")
            termsAndConditions.isChecked = true
        }
    }

    // Override the onBackPressed() function to handle back press
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // Navigate to LoginActivity when the back button is pressed
        val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish the SignUpActivity so the user can't go back to it
    }
}
