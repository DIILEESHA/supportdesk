package com.example.sllitsupportdesk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val titleTextView: TextView = findViewById(R.id.noteDetailTitle)
        val descriptionTextView: TextView = findViewById(R.id.noteDetailDescription)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        titleTextView.text = title
        descriptionTextView.text = description
    }
}
