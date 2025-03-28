package com.example.sllitsupportdesk

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Homepage : AppCompatActivity() {

    private lateinit var searchBar: SearchView
    private lateinit var noticesContainer: LinearLayout
    private lateinit var tabAll: TextView
    private lateinit var tabAcademic: TextView
    private lateinit var tabEvents: TextView
    private lateinit var tabGeneral: TextView

    private val allNotices = listOf(
        Notice("Academic", "Class schedule updated."),
        Notice("Events", "Annual tech fest on April 5th."),
        Notice("General", "Campus maintenance on Sunday."),
        Notice("Academic", "Exam results will be released next week."),
        Notice("Events", "Guest lecture on AI this Friday."),
        Notice("General", "New cafeteria menu available.")
    )

    private var filteredNotices = allNotices

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        searchBar = findViewById(R.id.searchBar)
        tabAll = findViewById(R.id.tabAll)
        tabAcademic = findViewById(R.id.tabAcademic)
        tabEvents = findViewById(R.id.tabEvents)
        tabGeneral = findViewById(R.id.tabGeneral)
        noticesContainer = findViewById(R.id.noticesContainer)

        // Display initial notices
        displayNotices(filteredNotices)

        // Set click listeners for category tabs
        tabAll.setOnClickListener { filterNotices("All") }
        tabAcademic.setOnClickListener { filterNotices("Academic") }
        tabEvents.setOnClickListener { filterNotices("Events") }
        tabGeneral.setOnClickListener { filterNotices("General") }

        // Add search functionality
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterSearchResults(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterSearchResults(newText)
                return true
            }
        })

        // Bottom Navigation setup
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Reload or stay on Home
                    true
                }
                R.id.nav_notices -> {
                    // Optionally reload or go to another activity
                    val intent = Intent(this, NoticesActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun filterNotices(category: String) {
        filteredNotices = if (category == "All") {
            allNotices
        } else {
            allNotices.filter { it.category == category }
        }
        displayNotices(filteredNotices)
    }

    private fun filterSearchResults(query: String?) {
        val searchQuery = query?.lowercase() ?: ""
        val results = filteredNotices.filter { it.message.lowercase().contains(searchQuery) }
        displayNotices(results)
    }

    private fun displayNotices(notices: List<Notice>) {
        noticesContainer.removeAllViews()
        for (notice in notices) {
            val noticeView = layoutInflater.inflate(R.layout.notice_card, noticesContainer, false)
            val categoryText: TextView = noticeView.findViewById(R.id.noticeCategory)
            val titleText: TextView = noticeView.findViewById(R.id.noticeTitle)
            val messageText: TextView = noticeView.findViewById(R.id.noticeMessage)

            categoryText.text = notice.category
            titleText.text = notice.title
            messageText.text = notice.message

            noticesContainer.addView(noticeView)
        }
    }
}

// Data class for a Notice
data class Notice(val category: String, val message: String, val title: String = "Notice")
