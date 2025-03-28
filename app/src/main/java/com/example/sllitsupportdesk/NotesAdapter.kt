package com.example.sllitsupportdesk

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notesList: MutableList<Note>, private val context: Context) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.noteItemTitle)
        val description: TextView = view.findViewById(R.id.noteItemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
        holder.title.text = note.title
        holder.description.text = note.description

        // Set Click Listener
        holder.itemView.setOnClickListener {
            val intent = Intent(context, NoteDetailActivity::class.java)
            intent.putExtra("title", note.title)
            intent.putExtra("description", note.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = notesList.size

    fun updateList(newList: List<Note>) {
        notesList.clear()
        notesList.addAll(newList)
        notifyDataSetChanged()
    }
}
